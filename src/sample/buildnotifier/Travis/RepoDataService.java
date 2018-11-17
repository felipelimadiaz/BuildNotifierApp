package sample.buildnotifier.Travis;

import javafx.concurrent.ScheduledService;
import javafx.concurrent.Task;

public class RepoDataService extends ScheduledService<TravisRepoData> {
    private TravisApi travisApi;

    public RepoDataService(TravisApi travisApi){
        this.travisApi = travisApi;
    }

    @Override
    protected Task<TravisRepoData> createTask() {
        final TravisApi travisApi = this.travisApi;
        return new Task<TravisRepoData>() {
            protected TravisRepoData call()
                    throws Exception {
                TravisRepoData result = travisApi.getRepoData();
                return result;
            }
        };
    }
}
