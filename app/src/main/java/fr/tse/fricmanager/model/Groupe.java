package fr.tse.fricmanager.model;

import java.util.List;

public class Groupe {

    private String mName;
    private List<User> mUsers;
    private List<Depense> mDepenses;

    public Groupe(String name) {
        this.mName = name;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String name) {
        this.mName = name;
    }

    public List<User> getmUsers() {
        return mUsers;
    }

    public void setmUsers(List<User> users) {
        this.mUsers = users;
    }

    public List<Depense> getmDepenses() {
        return mDepenses;
    }

    public void setmDepenses(List<Depense> depenses) {
        this.mDepenses = depenses;
    }
}
