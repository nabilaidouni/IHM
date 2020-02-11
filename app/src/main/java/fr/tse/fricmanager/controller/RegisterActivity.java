package fr.tse.fricmanager.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;

import fr.tse.fricmanager.R;
import fr.tse.fricmanager.model.User;

//import fr.tse.fricmanager.R;

public class RegisterActivity extends AppCompatActivity {

    EditText username, password, password2;
    ArrayList<User> listeUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        username = findViewById(R.id.editTextPseudo);
        password = findViewById(R.id.editTextPassword);
        password2 = findViewById(R.id.editTextPassword2);
        Intent intent = this.getIntent();
        Bundle bd = intent.getExtras();
        listeUser = (ArrayList<User>)bd.getSerializable("listeUser");
    }

    public void register(View view){

        boolean existeDeja = false;
        for (int i = 0; i < listeUser.size();i++){
            if (listeUser.get(i).getmName().contentEquals(username.getText().toString())){
                existeDeja = true;
            }
        }
        if (!existeDeja & (password.getText().toString().contentEquals(password2.getText().toString()))){
            Log.d("mon message", "le pseudo est bon");
            User nouveauUtil = new User(username.getText().toString(), password.getText().toString());
            listeUser.add(nouveauUtil);

            Intent LoginActivity = new Intent(RegisterActivity.this, LoginActivity.class);
            Bundle bd = new Bundle();
            bd.putSerializable("listeUser", listeUser);
            LoginActivity.putExtras(bd);
            startActivity(LoginActivity);

        }
    }
}
