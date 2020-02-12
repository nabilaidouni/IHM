package fr.tse.fricmanager.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import fr.tse.fricmanager.R;
import fr.tse.fricmanager.model.Depense;
import fr.tse.fricmanager.model.Groupe;
import fr.tse.fricmanager.model.User;
import fr.tse.fricmanager.model.UserBank;

import static java.util.Arrays.*;

public class NewGroupActivity extends AppCompatActivity {

    private Groupe mGroupe;
    private List<Groupe> mGroupeBank =  new ArrayList<>();

    ArrayList<Groupe> listeGroupe;
    User userLogged;
    ArrayList<User> listeUser;
    ArrayList<Depense> listeDepense;

    private Button mCreateGroupe;

    private EditText mNameGroupe;
    private LinearLayout lLayout;





    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_group);

        mCreateGroupe = findViewById(R.id.button_create_groupe);
        lLayout = findViewById(R.id.linearLayout);
        mNameGroupe = findViewById(R.id.text_groupe_name);
        mGroupeBank = (List<Groupe>) getIntent().getSerializableExtra("MyGroupe");

        Intent intent = this.getIntent();
        Bundle bd = intent.getExtras();
        listeUser = (ArrayList<User>)bd.getSerializable("listeUser");
        userLogged =(User)bd.getSerializable("userLogged");
        listeGroupe = (ArrayList<Groupe>)bd.getSerializable("listeGroupe");
        listeDepense = (ArrayList<Depense>)bd.getSerializable("listeDepense");

        for(int i=0;i<listeUser.size();i++){
            CheckBox b = new CheckBox(this);
            b.setText(listeUser.get(i).getmName());
            b.setId(i);
            lLayout.addView(b);
        }


        mCreateGroupe.setOnClickListener(new View.OnClickListener() {
          //  @Override
            public void onClick(View view) {
               String Name = mNameGroupe.getText().toString();
               mGroupe = new Groupe(Name);
                ArrayList<User> userNouveauGroupe = new ArrayList<>();


                for(int i=0;i<listeUser.size();i++) {
                    CheckBox checkBox = findViewById(i);
                    if (checkBox.isChecked()) {
                        String user = checkBox.getText().toString();
                        for (int j = 0; j < listeUser.size(); j++) {
                            if (listeUser.get(j).getmName().equals(user)) {

                                if (listeUser.get(j) != null) {
                                    userNouveauGroupe.add(listeUser.get(j));
                                }
                            }
                        }
                    }
                }

                mGroupe.setmUsers(userNouveauGroupe);
                listeGroupe.add(mGroupe);

                Toast.makeText(getApplicationContext(),"Groupe added",Toast.LENGTH_SHORT).show();

                Intent groupActivityIntent = new Intent(NewGroupActivity.this,GroupActivity.class);
                groupActivityIntent.putExtras(creerBundle());
                startActivity(groupActivityIntent);

            }
        });
    }

    private Bundle creerBundle() {
        Bundle bd = new Bundle();
        bd.putSerializable("listeUser", listeUser);
        bd.putSerializable("userLogged", userLogged);
        bd.putSerializable("listeGroupe", listeGroupe);
        bd.putSerializable("listeDepense", listeDepense);
        return bd;

    }


}