package gui

import entity.Teams
import entity.TeamDAO
import javafx.collections.FXCollections
import javafx.fxml.FXML
import javafx.scene.control.TableColumn
import javafx.scene.control.TableView
import javafx.scene.control.TextField
import javafx.scene.control.cell.PropertyValueFactory

class TeamController() {
    val dao: TeamDAO = TeamDAO()
    @FXML var teamText: TextField? = null
    @FXML var teampnameText: TextField? = null
    @FXML var teamTable: TableView<Teams>? = null
    @FXML var teamTeamsidCol: TableColumn<Teams, Int>? = null
    @FXML var teamTeamsnameCol: TableColumn<Teams, String>? = null
    @FXML var teamidCol: TableColumn<Teams, Int>? = null
    @FXML var teamnameCol: TableColumn<Teams, String>? = null

    @FXML fun initialize(): Unit {
        println("from team init")
        teamTeamsidCol?.setProperty("pid")
        teamTeamsnameCol?.setProperty("name")
        teamidCol?.setProperty("id")
        teamnameCol?.setProperty("name")
        teamTeamsidCol?.setCellValueFactory(PropertyValueFactory<Teams, Int>("pid"))
        teamTeamsnameCol?.setCellValueFactory(PropertyValueFactory<Teams, String>("pname"))
        teamidCol?.setCellValueFactory(PropertyValueFactory<Teams, Int>("id"))
        teamnameCol?.setCellValueFactory(PropertyValueFactory<Teams, String>("name"))
        refresh()
    }

    fun refresh() {
        val Teams = FXCollections.observableList(dao.findAllTeams())

        teamTable?.setItems(Teams)
    }

    fun add(): Unit {
        val Teams: Teams = Teams()
        Teams.pid = teamText?.getText()?.toInt() as Int
        Teams.name = teampnameText?.getText() as String        
        dao.create(Teams)

        refresh()
    }

    fun delete(): Unit {
        val Teams: Teams? = teamTable?.getSelectionModel()?.getSelectedItem()
        dao.delete(Teams)

        refresh()
    }

    fun <T, S> TableColumn<S, T>.setProperty(property: String) {
        setCellValueFactory(PropertyValueFactory<S, T>(property))
    }
}


