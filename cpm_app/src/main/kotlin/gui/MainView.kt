package gui

import entity.ProjectDAO
import entity.TaskDAO
import entity.TeamDAO
import javafx.application.Application
import javafx.stage.Stage
import javafx.fxml.FXMLLoader
import javafx.scene.Scene
import javafx.scene.Parent


class MainView() : Application() {
    override fun start(stage: Stage?) {
        val parent: Parent? = FXMLLoader.load(MainView().javaClass.getClassLoader().getResource("view/Main.fxml"))
        stage?.setTitle("Project Management System(PMS)")
        stage?.setScene(Scene(parent))
        stage?.show()
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val tdao : TaskDAO = TaskDAO()
            val pdao : ProjectDAO = ProjectDAO()
            val ptdao : TeamDAO = TeamDAO()
            tdao.findAllTask()?.forEach { x -> println(x?.name) }
            pdao.findAllProject()?.forEach { x -> println(x?.name) }
            ptdao.findAllTeams()?.forEach { x -> println(x?.name) }
            launch(MainView::class.java)
        }
    }
}