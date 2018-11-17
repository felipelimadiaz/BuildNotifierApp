package sample.buildnotifier.Travis;

public interface TravisUser {
    int getId();
    String getLogin();
    String getName();
    int getGitHubId();
    String getAvatarUrl();
    boolean getEducation();
    boolean isSync();
    String getSyncedAt();
}
