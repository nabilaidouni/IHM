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
import fr.tse.fricmanager.model.Groupe;

public class GroupActivity extends AppCompatActivity  {
    private List<Groupe> newGroupe;
    private List<Groupe> mGroupes;
    private Button mButtonNew;
    private ImageButton nextGroupe;
    private LinearLayout lLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group);
        newGroupe = (List<Groupe>) getIntent().getSerializableExtra("MyNewGroup");
        mButtonNew = findViewById(R.id.button_new_groupe);
        lLayout =  findViewById(R.id.layout);
        nextGroupe = findViewById(R.id.mgroupeButton);
        if (newGroupe == null){
            mGroupes = createGroupes();
        }
        if (newGroupe != null ){
            mGroupes = newGroupe;
        }

        for(int i=0;i<mGroupes.size();i++){
            Button b = new Button(this);
            b.setText(mGroupes.get(i).getmName());

            lLayout.addView(b);
        }

        lLayout.getChildAt(0).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent showGroupActivity = new Intent(GroupActivity.this, ShowGroupActivity.class);
                showGroupActivity.putExtra("idGroupe", lLayout.getChildAt(0).getId());
                startActivity(showGroupActivity);
            }
        });


        mButtonNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent groupActivityIntent = new Intent(GroupActivity.this,NewGroupActivity.class);
                groupActivityIntent.putExtra("MyGroupe", (Serializable) mGroupes);
                startActivity(groupActivityIntent);


            }});

        nextGroupe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent groupaActivityIntent = new Intent(GroupActivity.this,GroupActivity.class);
                startActivity(groupaActivityIntent);


            }});

    }



    private List<Groupe> createGroupes() {
        Groupe groupe1;
        groupe1 = new Groupe("Coloc");
        Groupe groupe2;
        groupe2 = new Groupe("Travail");
        Groupe groupe3;
        groupe3 = new Groupe("École");
        List<Groupe> allGroupes = new ArrayList<>();
        allGroupes.add(groupe1);
        allGroupes.add(groupe2);
        allGroupes.add(groupe3);

        return allGroupes;}




    }




