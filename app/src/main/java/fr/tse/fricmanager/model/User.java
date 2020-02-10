package fr.tse.fricmanager.model;

import java.util.List;

public class User {

    private String mName;
    private String mPassword;
    private List<Groupe> mGroups;
    private List<Depense> mDepenses;

    public User(String name, String password) {
        this.mName = name;
        this.mPassword = password;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String name) {
        this.mName = name;
    }

    public String getmPassword() {
        return mPassword;
    }

    public void setmPassword(String password) {
        this.mPassword = password;
    }

    public List<Groupe> getmGroups() {
        return mGroups;
    }

    public void setmGroups(List<Groupe> groups) {
        this.mGroups = groups;
    }

    public List<Depense> getmDepenses() {
        return mDepenses;
    }

    public void setmDepenses(List<Depense> depenses) {
        this.mDepenses = depenses;
    }
}
