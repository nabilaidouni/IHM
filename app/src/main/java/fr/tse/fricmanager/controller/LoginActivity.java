package fr.tse.fricmanager.controller;

import androidx.appcompat.app.AppCompatActivity;
import android.widget.EditText;
import android.view.View;
import android.content.Intent;
import fr.tse.fricmanager.R;
import fr.tse.fricmanager.model.*;



import android.os.Bundle;
import android.widget.Toast;

import java.security.acl.Group;
import java.util.ArrayList;

public class LoginActivity extends AppCompatActivity {

    EditText username, password;
    ArrayList<Groupe> listeGroupe;
    ArrayList<User> listeUser;
    ArrayList<Depense> listeDepense;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        username = findViewById(R.id.editTextLogin);
        password = findViewById(R.id.editTextPassword);

        // On essaye de recupérer les données déjà enregistrées
        try {
            Intent intent = this.getIntent();
            Bundle bd = intent.getExtras();
            listeUser = (ArrayList<User>)bd.getSerializable("listeUser");
            listeGroupe = (ArrayList<Groupe>)bd.getSerializable("listeGroupe");
            listeDepense = (ArrayList<Depense>)bd.getSerializable("listeDepense");

        }
        // Si il n'y a pas encore de données on les créées
        catch (Exception e){
            listeUser = new ArrayList<>();
            listeGroupe = new ArrayList<>();
            listeDepense = new ArrayList<>();

            User admin = new User("admin","admin");
            User user = new User("user","user");
            User user1 = new User("Lia", "1234");
            User user2 = new User("Nabil", "1234");
            User user3 = new User("Etienne", "1234");

            listeUser.add(admin);
            listeUser.add(user);
            listeUser.add(user1);
            listeUser.add(user2);
            listeUser.add(user3);

            Groupe groupe1 = new Groupe("Coloc");
            groupe1.addmUser(user1);
            Groupe groupe2 = new Groupe("Travail");
            groupe2.addmUser(user1);
            Groupe groupe3 = new Groupe("École");
            groupe3.addmUser(user1);


            Groupe test = new Groupe("groupeTest");
            test.addmUser(admin);
            test.addmUser(user);
            listeGroupe.add(test);
            listeGroupe.add(groupe1);
            listeGroupe.add(groupe2);
            listeGroupe.add(groupe3);


        }

    }

    public void login(View view) {
        String user = username.getText().toString();

        try{
            User userlogged = validateLogin(user, password.getText().toString());



            Intent CrudGroupActivity = new Intent(LoginActivity.this, GroupActivity.class);
            Bundle bd = creerBundle();
            bd.putSerializable("userLogged", userlogged);
            CrudGroupActivity.putExtras(bd);
            startActivity(CrudGroupActivity);
        }
        catch (Exception e){
            Toast.makeText(getApplicationContext(), "Le nom d'utilisateur ou le mot de passe ne sont pas corrects", Toast.LENGTH_LONG).show();

        }
    }

    public void register(View view){
        Intent RegisterActivity = new Intent(LoginActivity.this, RegisterActivity.class);

        RegisterActivity.putExtras(creerBundle());
        startActivity(RegisterActivity);
    }

    private User validateLogin(String userName, String password) throws Exception{
        int n = this.listeUser.size();
        boolean rend = false;
        for (int i = 0; i<n; i++){
            if (this.listeUser.get(i).getmName().contentEquals(userName) & this.listeUser.get(i).getmPassword().contentEquals(password)){
                return this.listeUser.get(i);
            }
        }
        throw new Exception("mauvaise validation");
    }

    private Bundle creerBundle(){
        Bundle bd = new Bundle();
        bd.putSerializable("listeUser", listeUser);
        bd.putSerializable("listeGroupe", listeGroupe);
        bd.putSerializable("listeDepense", listeDepense);
        return bd;
    }
}
