/*
import javafx.application.Application;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.scene.control.TableView;
import java.io.IOException;

import javafx.scene.layout.AnchorPane;
import models.Project;
import models.ProjectsData;

public class MainApp extends Application {

    private Stage primaryStage;
    private AnchorPane rootLayout;
    @FXML
    private TableView tableView;
    //@FXML private TableColumn<Project, String> pid;


    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Project Management System(PMS)");

        initRootLayout();

        //showPersonOverview();
    }



    */
/**
     * Initializes the root layout.
     *//*

    public void initRootLayout() {
        try {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/ProjectList.fxml"));
            rootLayout = (AnchorPane) loader.load();



            // Show the scene containing the root layout.
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    */
/**
     * Shows the person overview inside the root layout.
     *//*

    public void showPersonOverview() {
        try {
            // Load person overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("view/ProjectList.fxml"));
            AnchorPane personOverview = (AnchorPane) loader.load();

            // Set person overview into the center of root layout.
           // rootLayout.setCenter(personOverview);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    */
/**
     * Returns the main stage.
     * @return
     *//*

    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
*/
