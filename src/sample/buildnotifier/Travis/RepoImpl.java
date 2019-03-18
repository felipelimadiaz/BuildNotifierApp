package sample.buildnotifier.Travis;

import sample.buildnotifier.Build;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.EventHandler;
import javafx.util.Duration;
import sample.buildnotifier.Observer;
import sample.buildnotifier.Repo;
import java.util.ArrayList;
import java.util.List;


public class RepoImpl implements Repo {
    RepoDataService repoDataService;
    ArrayList<Build> listBuilds = new ArrayList<Build>();
    List<Build> subListBuilds = new ArrayList<>();
    ArrayList<Observer> listObservers = new ArrayList<Observer>();


    public RepoImpl(RepoDataService repoDataService) throws Exception {
        this.repoDataService = repoDataService;

        repoDataService.setOnSucceeded(new RepoEventsHandler(this));
        this.repoDataService.setPeriod(Duration.seconds(5));

        this.repoDataService.start();
    }

    @Override
    public List<Build> getBuilds() throws Exception {
        return subListBuilds;

    }

    @Override
    public void addObserver(Observer observer) {
        this.listObservers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        this.listObservers.remove(observer);
    }

    private void notifyObserver() throws Exception {
        for (Observer observer : this.listObservers){
            observer.update();
        }
    }

    private class RepoEventsHandler implements EventHandler<WorkerStateEvent> {

        private RepoImpl repoImplParent;

        public RepoEventsHandler(RepoImpl repoImplParent){
            this.repoImplParent = repoImplParent;
        }

        @Override
        public void handle(WorkerStateEvent t)  {
            try{
                TravisRepoData travisRepoData = (TravisRepoData) t.getSource().getValue();
                TravisBuildData[] buildsOld = travisRepoData.getBuilds();
                listBuilds.clear();
                for (TravisBuildData buildData : buildsOld) {
                    BuildImpl build = new BuildImpl();
                    build.setState(buildData.getState());
                    listBuilds.add(build);
                }

                subListBuilds = listBuilds.subList(0,10);
                this.repoImplParent.notifyObserver();
            }
            catch(Exception e){
                int x = 3;
            }

        }
    }
}
