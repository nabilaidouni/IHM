package fr.tse.fricmanager.model;

public class Depense {

    private Long mValue;
    private String mDescription;
    private Groupe mGroupe;
    private User mUser;

    public Depense(Long value, String description, Groupe groupe, User user) {
        this.mValue = value;
        this.mDescription = description;
        this.mGroupe = groupe;
        this.mUser = user;
    }

    public Long getmValue() {
        return mValue;
    }

    public void setmValue(Long value) {
        this.mValue = value;
    }

    public String getmDescription() {
        return mDescription;
    }

    public void setmDescription(String description) {
        this.mDescription = description;
    }

    public Groupe getmGroupe() {
        return mGroupe;
    }

    public void setmGroupe(Groupe groupe) {
        this.mGroupe = groupe;
    }

    public User getmUser() {
        return mUser;
    }

    public void setmUser(User user) {
        this.mUser = user;
    }
}
