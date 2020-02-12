package fr.tse.fricmanager.model;

import java.io.Serializable;
import java.util.List;

public class UserBank implements Serializable {
    private List<User> mUserList;

    public UserBank(List<User> mUserList) {
        this.mUserList = mUserList;
    }

    public List<User> getmUserList() {
        return mUserList;
    }

    public void setmUserList(List<User> mUserList) {
        this.mUserList = mUserList;
    }
}
