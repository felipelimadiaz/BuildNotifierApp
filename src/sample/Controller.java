package sample;

import javafx.fxml.FXML;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.*;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import sample.buildnotifier.Build;
import sample.buildnotifier.Observer;
import sample.buildnotifier.Repo;
import sample.buildnotifier.RepoFactory;
import sample.buildnotifier.Travis.RepoFactoryImpl;
import java.util.List;

public class Controller implements Observer {

    private Repo repo;
    @FXML
    private VBox vBox;
    @FXML
    private VBox vBox2;
    @FXML
    private AnchorPane pane;
    @FXML
    private ScrollPane scrollPane;

    public void initialize() throws Exception {
        RepoFactory repoFactory = new RepoFactoryImpl();
        this.repo = repoFactory.getRepo();
        repo.addObserver(this);
        this.vBox.prefWidthProperty().bind(this.pane.widthProperty().multiply(1));
        this.vBox.prefHeightProperty().bind(this.pane.heightProperty().multiply(1));
        this.vBox.setStyle("-fx-border-color: black;" + "-fx-border-style: solid;" + "-fx-border-width: 1;" + "-fx-background-color: rgb(225, 228, 203);");
        this.vBox2.prefWidthProperty().bind(this.vBox.widthProperty().multiply(1));
        this.vBox2.prefHeightProperty().bind(this.vBox.heightProperty().multiply(1));

        for (Build build : repo.getBuilds()) {
            Label label = new Label(build.getState());
            this.vBox2.getChildren().add(label);
        }
    }

    @Override
    public void update() throws Exception {
        List<Build> builds = repo.getBuilds();
        this.vBox2.getChildren().clear();

        for (Build build : builds){
            Label label = new Label(build.getState());
            label.setStyle("-fx-border-color: black;" + "-fx-border-style: solid solid none solid;" + "-fx-border-width: 1");
            label.prefWidthProperty().bind(this.vBox2.widthProperty().multiply(1));
            label.prefHeightProperty().bind(this.vBox2.heightProperty().multiply(1));
            label = this.setColor(label);
            this.vBox2.getChildren().add(label);
        }

    }

    private Label setColor(Label label){
        if (label.getText().equals("passed")){
            label.setTextFill(Color.web("#228B22"));
        }
        else if (label.getText().equals("canceled")){
            label.setTextFill(Color.web("#FF0000"));
        }
        else{
            label.setTextFill(Color.web("#ffa500"));
        }


        return label;
    }
}
