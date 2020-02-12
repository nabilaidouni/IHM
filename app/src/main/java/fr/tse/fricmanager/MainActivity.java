package fr.tse.fricmanager;

import androidx.appcompat.app.AppCompatActivity;
import android.widget.EditText;
import android.view.View;
import android.content.Intent;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {


    EditText username, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = findViewById(R.id.editTextLogin);
        password = findViewById(R.id.editTextPassword);
    }

    public void login(View view) {
        if (username.getText().toString().equals("admin") && password.getText().toString().equals("admin")) {
            Intent MainActivity = new Intent(fr.tse.fricmanager.MainActivity.this, fr.tse.fricmanager.MainActivity.class);
            startActivity(MainActivity);
            //correcct password
        } else {
            //wrong password
        }
    }
}
