package gui

import entity.Task
import entity.TaskDAO
import javafx.collections.FXCollections
import javafx.fxml.FXML
import javafx.scene.control.TableColumn
import javafx.scene.control.TableView
import javafx.scene.control.TextField
import javafx.scene.control.cell.PropertyValueFactory

class TaskController() {
    val dao: TaskDAO = TaskDAO()
    @FXML var taskText: TextField? = null
    @FXML var costText: TextField? = null
    @FXML var dpText: TextField? = null
    @FXML var taskTable: TableView<Task>? = null
    @FXML var taskCol: TableColumn<Task, String>? = null
    @FXML var costCol: TableColumn<Task, Int>? = null
    @FXML var dpCol: TableColumn<Task, String>? = null

    @FXML fun initialize(): Unit {
        println("from task init")
        taskCol?.setProperty("name")
        costCol?.setProperty("cost")
        costCol?.setProperty("dependencies")
        taskCol?.setCellValueFactory(PropertyValueFactory<Task, String>("name"))
        costCol?.setCellValueFactory(PropertyValueFactory<Task, Int>("cost"))
        dpCol?.setCellValueFactory(PropertyValueFactory<Task, String>("dependencies"))
        refresh()
    }

    fun refresh() {
        val Tasks = FXCollections.observableList(dao.findAllTask())

        taskTable?.setItems(Tasks)
    }

    fun add(): Unit {
        val Task: Task = Task()
        Task.name = taskText?.getText() as String
        Task.cost = costText?.getText()?.toInt() as Int
        Task.dependencies = dpText?.getText() as String
        dao.create(Task)

        refresh()
    }

    fun delete(): Unit {
        val Task: Task? = taskTable?.getSelectionModel()?.getSelectedItem()
        dao.delete(Task)

        refresh()
    }

    fun <T, S> TableColumn<S, T>.setProperty(property: String) {
        setCellValueFactory(PropertyValueFactory<S, T>(property))
    }
}


