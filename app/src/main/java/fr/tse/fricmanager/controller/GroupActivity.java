package fr.tse.fricmanager.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import fr.tse.fricmanager.R;
import fr.tse.fricmanager.model.Depense;
import fr.tse.fricmanager.model.Groupe;
import fr.tse.fricmanager.model.User;

public class GroupActivity extends AppCompatActivity  {

    ArrayList<Groupe> listeGroupe;
    User userLogged;
    ArrayList<User> listeUser;
    ArrayList<Depense> listeDepense;

    private Button mButtonNew;
    private ImageButton nextGroupe;
    private LinearLayout lLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group);
        mButtonNew = findViewById(R.id.button_new_groupe);
        lLayout =  findViewById(R.id.layout);
        nextGroupe = findViewById(R.id.mgroupeButton);

        Intent intent = this.getIntent();
        Bundle bd = intent.getExtras();
        listeUser = (ArrayList<User>)bd.getSerializable("listeUser");
        userLogged =(User)bd.getSerializable("userLogged");
        listeGroupe = (ArrayList<Groupe>)bd.getSerializable("listeGroupe");
        listeDepense = (ArrayList<Depense>)bd.getSerializable("listeDepense");

        for(int i=0;i<listeGroupe.size();i++){
            Button b = new Button(this);
            b.setText(listeGroupe.get(i).getmName());

            lLayout.addView(b);
        }

        lLayout.getChildAt(0).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent showGroupActivity = new Intent(GroupActivity.this, ShowGroupActivity.class);
                Bundle bd = creerBundle();
                bd.putSerializable("idGroupe", lLayout.getChildAt(0).getId());
                showGroupActivity.putExtras(bd);
                startActivity(showGroupActivity);
            }
        });


        mButtonNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent groupActivityIntent = new Intent(GroupActivity.this,NewGroupActivity.class);
                groupActivityIntent.putExtras(creerBundle());
                startActivity(groupActivityIntent);


            }});

        nextGroupe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent groupaActivityIntent = new Intent(GroupActivity.this,GroupActivity.class);
                startActivity(groupaActivityIntent);


            }});

    }

    public void addDepense(View view){
        Intent CrudGroupActivity = new Intent(GroupActivity.this, NewDepenseActivity.class);
        Bundle bd = creerBundle();
        CrudGroupActivity.putExtras(bd);
        startActivity(CrudGroupActivity);
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




