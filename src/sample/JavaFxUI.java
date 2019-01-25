package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import sample.buildnotifier.Observer;

import java.awt.*;

public class JavaFxUI extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("GUI.fxml"));
        primaryStage.setTitle("Build Status");
        primaryStage.setScene(new Scene(root, 288, 342));
        primaryStage.setResizable(false);
        primaryStage.getIcons().add(new Image("file:C:/Git/BuildNotifierApp/Cane_toad.jpg"));
        primaryStage.show();

    }


    public static void launch(String[] args) {
        Application.launch(args);
    }
}
