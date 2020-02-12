package fr.tse.fricmanager.controller;

import androidx.appcompat.app.AppCompatActivity;
import fr.tse.fricmanager.model.*;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;

import fr.tse.fricmanager.R;

import static java.lang.Long.parseLong;

public class NewDepenseActivity extends AppCompatActivity {

    EditText username, montant, motif;
    Groupe groupeDepense;
    ArrayList<Groupe> listeGroupe;
    User userLogged;
    ArrayList<User> listeUser;
    ArrayList<Depense> listeDepense;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_depense);

        Intent intent = this.getIntent();
        Bundle bd = intent.getExtras();
        listeUser = (ArrayList<User>)bd.getSerializable("listeUser");
        userLogged =(User)bd.getSerializable("userLogged");
        listeGroupe = (ArrayList<Groupe>)bd.getSerializable("listeGroupe");
        groupeDepense = (Groupe)bd.getSerializable("groupeDepense");
        listeDepense = (ArrayList<Depense>)bd.getSerializable("listeDepense");

        username = findViewById(R.id.editTextUser);
        montant = findViewById(R.id.editTextMontant);
        motif = findViewById(R.id.editTextMotif);
    }

    public void saveDepense(View view){
        Depense nouvelleDepence;
        nouvelleDepence = new Depense(parseLong(montant.getText().toString()), motif.getText().toString(), groupeDepense, userLogged);
        listeDepense.add(nouvelleDepence);


        Intent CrudDepenseActivity = new Intent(NewDepenseActivity.this, CrudDepenseActivity.class);
        CrudDepenseActivity.putExtras(creerBundle());
        startActivity(CrudDepenseActivity);

    }

    private Bundle creerBundle(){
        Bundle bd = new Bundle();
        bd.putSerializable("listeUser", listeUser);
        bd.putSerializable("userLogged", userLogged);
        bd.putSerializable("listeGroupe", listeGroupe);
        bd.putSerializable("listeDepense", listeDepense);
        return bd;
    }
}
