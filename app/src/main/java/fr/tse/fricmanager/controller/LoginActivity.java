package fr.tse.fricmanager.controller;

import androidx.appcompat.app.AppCompatActivity;
import android.widget.EditText;
import android.view.View;
import android.content.Intent;
import fr.tse.fricmanager.R;
import fr.tse.fricmanager.model.*;



import android.os.Bundle;

import java.util.ArrayList;

public class LoginActivity extends AppCompatActivity {

    EditText username, password;
    ArrayList<User> listeUser;

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
        }
        catch (Exception e){
            listeUser = new ArrayList<>();

        }
        User admin = new User("admin","admin");
        User user = new User("user","user");
        listeUser.add(admin);
        listeUser.add(user);
    }

    public void login(View view) {
        String user = username.getText().toString();
        if (validateLogin(user, password.getText().toString())) {
            Intent CrudGroupActivity = new Intent(LoginActivity.this, CrudGroupActivity.class);
            Bundle bd = new Bundle();
            bd.putSerializable("listeUser", listeUser);
            CrudGroupActivity.putExtras(bd);
            startActivity(CrudGroupActivity);
        } else {
            //wrong password
        }
    }

    public void register(View view){
        Intent RegisterActivity = new Intent(LoginActivity.this, RegisterActivity.class);
        Bundle bd = new Bundle();
        bd.putSerializable("listeUser", listeUser);
        RegisterActivity.putExtras(bd);
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
}
