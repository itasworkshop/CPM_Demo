import javafx.application.Application
import javafx.fxml.FXMLLoader
import javafx.scene.Parent
import javafx.scene.Scene
import javafx.scene.control.Label
import javafx.scene.layout.VBox
import javafx.stage.Stage

data class Team(@JvmField val id: Int, @JvmField val name: String)

class HelloWorldFXApp : Application() {

    override fun start(primaryStage: Stage?) {
        val team = Team(101,"AAA")
        val vbox = VBox()
        //val label = Label("Hello, World!")
        val label = Label(team.toString())

        vbox.children.add( label )

        val scene = Scene( vbox )

        primaryStage!!.scene = scene
        primaryStage.show()

    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            launch(HelloWorldFXApp::class.java)
        }
    }
}