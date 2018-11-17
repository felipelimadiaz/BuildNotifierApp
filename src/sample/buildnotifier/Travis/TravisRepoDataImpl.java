package sample.buildnotifier.Travis;

public class TravisRepoDataImpl implements TravisRepoData {
    TravisBuildDataImpl[] builds;
    @Override
    public TravisBuildData[] getBuilds() {
        return builds;
    }
}
