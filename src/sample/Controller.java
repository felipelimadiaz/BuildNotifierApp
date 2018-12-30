package sample;

import javafx.fxml.FXML;
import javafx.scene.layout.*;
import javafx.scene.control.Label;
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

    public void initialize() throws Exception {
        RepoFactory repoFactory = new RepoFactoryImpl();
        this.repo = repoFactory.getRepo();
        repo.addObserver(this);
        this.vBox.setStyle("-fx-border-color: black;" + "-fx-border-style: solid;" + "-fx-border-width: 1");
        this.vBox.prefWidthProperty().bind(this.pane.widthProperty().multiply(1));
        this.vBox.prefHeightProperty().bind(this.pane.heightProperty().multiply(1));

        for (Build build : repo.getBuilds()) {
            Label label = new Label(build.getState());
            this.vBox2.getChildren().add(label);
        }

    }

    @Override
    public void update() throws Exception {
        List<Build> builds = repo.getBuilds();
        this.vBox2.getChildren().clear();
        this.vBox2.prefWidthProperty().bind(this.vBox.widthProperty().multiply(1));
        this.vBox2.prefHeightProperty().bind(this.vBox.heightProperty().multiply(1));

        for (Build build : builds){
            Label label = new Label(build.getState());
            label.prefWidthProperty().bind(this.vBox2.widthProperty().multiply(1));
            label.prefHeightProperty().bind(this.vBox2.heightProperty().multiply(1));
            label.setStyle("-fx-border-color: black;" + "-fx-border-style: solid none none solid;" + "-fx-border-width: 1");
            this.vBox2.getChildren().add(label);
        }

    }
}
