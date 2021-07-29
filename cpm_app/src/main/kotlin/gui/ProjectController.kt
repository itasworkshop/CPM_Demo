package gui

import entity.Project
import entity.ProjectDAO
import javafx.collections.FXCollections
import javafx.fxml.FXML
import javafx.scene.control.TableColumn
import javafx.scene.control.TableView
import javafx.scene.control.TextField
import javafx.scene.control.cell.PropertyValueFactory

class ProjectController() {
    val dao: ProjectDAO = ProjectDAO()
    @FXML var pidText: TextField? = null
    @FXML var pnameText: TextField? = null
    @FXML var ptaskText: TextField? = null
    @FXML var projectTable: TableView<Project>? = null
    @FXML var pidCol: TableColumn<Project, Int>? = null
    @FXML var pnameCol: TableColumn<Project, String>? = null
    @FXML var ptaskCol: TableColumn<Project, String>? = null

    @FXML fun initialize(): Unit {
        println("from project init")
        pidCol?.setProperty("pid")
        pnameCol?.setProperty("name")
        ptaskCol?.setProperty("task")
        pidCol?.setCellValueFactory(PropertyValueFactory<Project, Int>("pid"))
        pnameCol?.setCellValueFactory(PropertyValueFactory<Project, String>("name"))
        ptaskCol?.setCellValueFactory(PropertyValueFactory<Project, String>("task"))
        refresh()
    }

    fun refresh() {
        val Projects = FXCollections.observableList(dao.findAllProject())

        projectTable?.setItems(Projects)
    }

    fun add(): Unit {
        val Project: Project = Project()
        Project.pid = pidText?.getText()?.toInt() as Int
        Project.name = pnameText?.getText() as String
        Project.task = ptaskText?.getText() as String
        dao.create(Project)

        refresh()
    }

    fun delete(): Unit {
        val Project: Project? = projectTable?.getSelectionModel()?.getSelectedItem()
        dao.delete(Project)

        refresh()
    }

    fun <T, S> TableColumn<S, T>.setProperty(property: String) {
        setCellValueFactory(PropertyValueFactory<S, T>(property))
    }
}


