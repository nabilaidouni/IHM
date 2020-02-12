package fr.tse.fricmanager.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

public class Groupe implements Serializable {

    private String mName;
    private List<User> mUsers;
    private List<Depense> mDepenses;

    public Groupe(String name) {
        this.mName = name;
        this.mUsers = new ArrayList<>();
        this.mDepenses = new ArrayList<>();
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
        for (int i = 0; i < users.size(); i++){
            this.addmUser(users.get(i));
        }
    }

    public List<Depense> getmDepenses() {
        return mDepenses;
    }

    public void setmDepenses(List<Depense> depenses) {
        this.mDepenses = depenses;
    }

    public void addmUser(User user){
        this.mUsers.add(user);
    };
}
