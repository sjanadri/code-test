package com.ge.exercise1;

import java.util.Collection;

public abstract class Application {
    private String name;

    public Application(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public abstract Collection<User> getUsers();

    public abstract User getUser(String userId);

    public abstract Collection<Group> getGroups();

    public abstract Group getGroup(String groupId);

}
