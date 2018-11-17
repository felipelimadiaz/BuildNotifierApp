package sample.buildnotifier.Travis;

public class TravisUserImpl implements TravisUser {
    private int id;
    private String login;
    private String name;
    private int github_id;
    private String avatar_url;
    private boolean education;
    private boolean is_syncing;
    private String synced_at;

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getLogin() {
        return login;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getGitHubId() {
        return github_id;
    }

    @Override
    public String getAvatarUrl() {
        return avatar_url;
    }

    @Override
    public boolean getEducation() {
        return education;
    }

    @Override
    public boolean isSync() {
        return is_syncing;
    }

    @Override
    public String getSyncedAt() {
        return synced_at;
    }
}
