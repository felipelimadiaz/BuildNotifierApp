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

    public void initialize() throws Exception {
        RepoFactory repoFactory = new RepoFactoryImpl();
        this.repo = repoFactory.getRepo();
        repo.addObserver(this);
        this.vBox.setStyle("-fx-border-color: black;" + "-fx-border-style: solid;" + "-fx-border-width: 1");

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
            label.setMaxWidth(250);
            label.setStyle("-fx-border-color: black;" + "-fx-border-style: solid none none solid;" + "-fx-border-width: 1");
            this.vBox2.getChildren().add(label);
        }

    }
}
