package sample.buildnotifier.Travis;

public interface TravisApi {
    TravisUser getUser() throws Exception;
    TravisRepoData getRepoData() throws Exception;
}
