package sample.buildnotifier;

import java.util.List;

public interface Repo extends Observable {
    List<Build> getBuilds() throws Exception;
}
