package fr.tse.fricmanager.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import fr.tse.fricmanager.R;
import fr.tse.fricmanager.model.Groupe;

public class ShowGroupActivity extends AppCompatActivity {
    private List<Groupe> mGroupeBank;
    private Groupe mGroupe;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_group);

        Intent in= getIntent();
        Bundle b = in.getExtras();
        mGroupeBank = createGroupes();
        if(b!=null)
        {
            int j = (Integer) b.get("idGroupe");
            mGroupe = mGroupeBank.get(j);
                }

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


