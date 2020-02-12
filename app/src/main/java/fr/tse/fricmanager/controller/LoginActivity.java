package fr.tse.fricmanager.controller;

import androidx.appcompat.app.AppCompatActivity;
import android.widget.EditText;
import android.view.View;
import android.content.Intent;
import fr.tse.fricmanager.R;
import fr.tse.fricmanager.model.*;



import android.os.Bundle;

import java.security.acl.Group;
import java.util.ArrayList;

public class LoginActivity extends AppCompatActivity {

    EditText username, password;
    Groupe groupeDepense;
    ArrayList<Groupe> listeGroupe;
    ArrayList<User> listeUser;
    ArrayList<Depense> listeDepense;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        username = findViewById(R.id.editTextLogin);
        password = findViewById(R.id.editTextPassword);
        try {
            Intent intent = this.getIntent();
            Bundle bd = intent.getExtras();
            listeUser = (ArrayList<User>)bd.getSerializable("listeUser");
            listeGroupe = (ArrayList<Groupe>)bd.getSerializable("listeGroupe");
            listeDepense = (ArrayList<Depense>)bd.getSerializable("listeDepense");

        }
        catch (Exception e){
            listeUser = new ArrayList<>();
            listeGroupe = new ArrayList<>();
            listeDepense = new ArrayList<>();


        }
        User admin = new User("admin","admin");
        User user = new User("user","user");
        listeUser.add(admin);
        listeUser.add(user);
    }

    public void login(View view) {
        String user = username.getText().toString();
        if (validateLogin(user, password.getText().toString())) {
            Intent CrudGroupActivity = new Intent(LoginActivity.this, NewDepenseActivity.class);
            Bundle bd = creerBundle();
            bd.putString("userLogged", user);
            CrudGroupActivity.putExtras(bd);
            startActivity(CrudGroupActivity);
        } else {
            //wrong password
        }
    }

    public void register(View view){
        Intent RegisterActivity = new Intent(LoginActivity.this, RegisterActivity.class);

        RegisterActivity.putExtras(creerBundle());
        startActivity(RegisterActivity);
    }

    private boolean validateLogin(String userName, String password){
        int n = this.listeUser.size();
        boolean rend = false;
        for (int i = 0; i<n; i++){
            if (this.listeUser.get(i).getmName().contentEquals(userName) & this.listeUser.get(i).getmPassword().contentEquals(password)){
                rend = true;
            }
        }
        return rend;
    }

    private Bundle creerBundle(){
        Bundle bd = new Bundle();
        bd.putSerializable("listeUser", listeUser);
        bd.putSerializable("listeGroupe", listeGroupe);
        bd.putSerializable("listeDepense", listeDepense);
        return bd;
    }
}
