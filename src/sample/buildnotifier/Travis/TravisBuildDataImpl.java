package sample.buildnotifier.Travis;

public class TravisBuildDataImpl implements TravisBuildData {
    private String state;

    @Override
    public String getState() {
        return this.state;
    }
}
