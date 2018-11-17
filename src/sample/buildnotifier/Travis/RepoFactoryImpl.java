package sample.buildnotifier.Travis;

import sample.buildnotifier.Repo;
import sample.buildnotifier.RepoFactory;

public class RepoFactoryImpl implements RepoFactory {
    @Override
    public Repo getRepo() throws Exception {
        TravisApi travisApi = new TravisApiImpl();
        RepoDataService repoDataService = new RepoDataService(travisApi);
        return new RepoImpl(repoDataService);
    }
}
