package gui

import entity.ProjectDAO
import entity.TaskDAO
import javafx.application.Application
import javafx.stage.Stage
import javafx.fxml.FXMLLoader
import javafx.scene.Scene
import javafx.scene.Parent


class MenuView() : Application() {
    override fun start(stage: Stage?) {
        val parent: Parent? = FXMLLoader.load(MenuView().javaClass.getClassLoader().getResource("view/Main.fxml"))
        stage?.setTitle("Project Management System(PMS)")
        stage?.setScene(Scene(parent))
        stage?.show()
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val tdao : TaskDAO = TaskDAO()
            val pdao : ProjectDAO = ProjectDAO()
            tdao.findAllTask()?.forEach { menu -> println(menu?.name) }
            pdao.findAllProject()?.forEach { menu -> println(menu?.name) }
            launch(MenuView::class.java)
        }
    }
}