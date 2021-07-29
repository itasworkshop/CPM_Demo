package controllers/*
package controllers

import javafx.collections.FXCollections
import javafx.collections.ObservableList
import javafx.fxml.FXML
import javafx.fxml.FXMLLoader
import javafx.fxml.Initializable
import javafx.scene.control.TableColumn
import javafx.scene.control.TableView
import javafx.scene.control.cell.PropertyValueFactory
import models.Project
import models.ProjectsData
import java.net.URL
import java.util.*

class ProjectListController : Initializable {

    [FXML] private val tableView: TableView<Project>? = null

    override fun initialize(url: URL?, rb: ResourceBundle?) {

        val columns: ObservableList<TableColumn<Project, *>>? = tableView?.columns
        println(columns)

        fun <T, S> TableColumn<S, T>.setProperty(property: String) {

            setCellValueFactory(PropertyValueFactory<S, T>(property))

        }
        columns?.get(0)?.setCellValueFactory(PropertyValueFactory<Project, String>("pid"))
        columns?.get(1)?.setCellValueFactory(PropertyValueFactory<Project, String>("pname"))

        val data = FXCollections.observableArrayList<Project>()
        data.addAll(ProjectsData().projectList)
        println(data)

        tableView.items.setAll(data)
    }
}*/
