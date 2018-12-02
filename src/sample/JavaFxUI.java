package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.buildnotifier.Observer;

public class JavaFxUI extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("GUI.fxml"));
        primaryStage.setTitle("Build Status");
        primaryStage.setScene(new Scene(root, 280, 350));
        primaryStage.setResizable(false);
        primaryStage.show();

    }


    public static void launch(String[] args) {
        Application.launch(args);
    }
}
