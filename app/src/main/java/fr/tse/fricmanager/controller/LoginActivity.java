package fr.tse.fricmanager.controller;

import androidx.appcompat.app.AppCompatActivity;
import android.widget.EditText;
import android.view.View;
import android.content.Intent;
import fr.tse.fricmanager.R;


import android.os.Bundle;

public class LoginActivity extends AppCompatActivity {

    EditText username, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        username = findViewById(R.id.editTextLogin);
        password = findViewById(R.id.editTextPassword);
    }

    public void login(View view) {
        if (username.getText().toString().equals("admin") && password.getText().toString().equals("admin")) {
            Intent CrudGroupActivity = new Intent(LoginActivity.this, CrudGroupActivity.class);
            startActivity(CrudGroupActivity);
            //correcct password
        } else {
            //wrong password
        }
    }

    public void register(View view){
        Intent RegisterActivity = new Intent(LoginActivity.this, RegisterActivity.class);
        startActivity(RegisterActivity);
    }
}
