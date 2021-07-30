import javafx.application.Application
import javafx.fxml.FXMLLoader
import javafx.scene.{Parent, Scene}
import javafx.stage.Stage

class MainViewScala extends Application {
  println("Test()")

  override def start(primaryStage: Stage): Unit = {
    val root: Parent = FXMLLoader.load(getClass().getResource("view/Main.fxml"))

    primaryStage.setTitle("Project Management System(PMS)")
    primaryStage.setScene(new Scene(root))
    primaryStage.show()
  }
}

object MainView {
  def main(args: Array[String]) {
    Application.launch(classOf[MainViewScala], args: _*)
  }
}
