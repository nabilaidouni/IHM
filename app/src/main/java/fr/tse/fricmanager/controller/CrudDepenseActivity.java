package fr.tse.fricmanager.controller;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

import fr.tse.fricmanager.R;
import fr.tse.fricmanager.model.Depense;
import fr.tse.fricmanager.model.Groupe;
import fr.tse.fricmanager.model.User;

public class CrudDepenseActivity extends AppCompatActivity {

    private LinearLayout lLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crud_depense);

       lLayout = (LinearLayout) findViewById(R.id.liste_depenses_layout);

        User u = new User("Jacky Chan","Coronavirus");

        Groupe g = new Groupe("Voyage Taïwan");

        List<Depense> depenses = new ArrayList<Depense>();

        Depense d1 = new Depense(12L,"le saucisson",g,u);
        Depense d2 = new Depense(18L,"le fromage",g,u);
        Depense d3 = new Depense(2L,"les chips",g,u);

        depenses.add(d1);
        depenses.add(d2);
        depenses.add(d3);

        List<Button> buttons;

        Button b0 = new Button(this);
        b0.setText("Ajouter une dépense");
        b0.setBackgroundColor(0x00ff00);
        lLayout.addView(b0);

        for(int i=0;i<depenses.size();i++){
            Button b = new Button(this);
            b.setText(depenses.get(i).getmDescription());
            lLayout.addView(b);
        }

        lLayout.getChildAt(0).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent newDepenseActivity = new Intent(CrudDepenseActivity.this, NewDepenseActivity.class);
                startActivity(newDepenseActivity);
            }
        });

    }
}
