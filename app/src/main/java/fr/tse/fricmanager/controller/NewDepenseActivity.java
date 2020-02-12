package fr.tse.fricmanager.controller;

import androidx.appcompat.app.AppCompatActivity;
import fr.tse.fricmanager.model.*;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

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
    CheckBox remboursement;



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

        remboursement = findViewById(R.id.checkBoxRemboursement);
        username = findViewById(R.id.editTextUser);
        montant = findViewById(R.id.editTextMontant);
        motif = findViewById(R.id.editTextMotif);
    }

    public void saveDepense(View view){
        Depense nouvelleDepence;
        try {
            long mont = parseLong(montant.getText().toString());
            nouvelleDepence = new Depense(mont , motif.getText().toString(), groupeDepense, userLogged);
            listeDepense.add(nouvelleDepence);

            Intent CrudDepenseActivity = new Intent(NewDepenseActivity.this, CrudDepenseActivity.class);
            //CrudDepenseActivity.putExtras(creerBundle());
            startActivity(CrudDepenseActivity);

        }
        catch (Exception e) {
            Toast.makeText(getApplicationContext(), "La valeur entrée n'est pas correcte", Toast.LENGTH_LONG).show();
        }



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
