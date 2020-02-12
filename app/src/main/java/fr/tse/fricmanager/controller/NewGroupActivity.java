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
import fr.tse.fricmanager.model.Groupe;
import fr.tse.fricmanager.model.User;
import fr.tse.fricmanager.model.UserBank;

import static java.util.Arrays.*;

public class NewGroupActivity extends AppCompatActivity {

    private UserBank mUser;
    private ArrayList<User> users = new ArrayList<>();
    //private List<User> users ;
    private Groupe mGroupe;
    private List<Groupe> mGroupeBank =  new ArrayList<>();
    private Button mCreateGroupe;
    private CheckBox checkBox0;
    private CheckBox checkBox1;
    private CheckBox checkBox2;
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
        mUser = getUsers();
        mGroupeBank = (List<Groupe>) getIntent().getSerializableExtra("MyGroupe");

        for(int i=0;i<mUser.getmUserList().size();i++){
            CheckBox b = new CheckBox(this);
            b.setText(mUser.getmUserList().get(i).getmName());
            b.setId(i);
            lLayout.addView(b);
        }

        checkBox0 = findViewById(0);
        checkBox1 = findViewById(1);
        checkBox2 = findViewById(2);

        mCreateGroupe.setOnClickListener(new View.OnClickListener() {
          //  @Override
            public void onClick(View view) {
               String Name = mNameGroupe.getText().toString();
               mGroupe = new Groupe(Name);

                if (checkBox0.isChecked()){
                   String user = checkBox0.getText().toString();
                   for(int i=0;i<mUser.getmUserList().size();i++){
                       if(mUser.getmUserList().get(i).getmName().equals(user)){

                           if (mUser.getmUserList().get(i) != null){
                               users.add( mUser.getmUserList().get(i));
                           }
                       }


                       }
                   }

                if (checkBox1.isChecked()){
                    String user = checkBox1.getText().toString();
                    for(int i=0;i<mUser.getmUserList().size();i++){
                        if(mUser.getmUserList().get(i).getmName().equals(user)){
                            if (mUser.getmUserList().get(i) != null){
                                users.add( mUser.getmUserList().get(i));
                        }
                    }
                }}
                if (checkBox2.isChecked()){
                    String user = checkBox2.getText().toString();
                    for(int i=0;i<mUser.getmUserList().size();i++){
                        if(mUser.getmUserList().get(i).getmName().equals(user)){
                            if (mUser.getmUserList().get(i) != null){
                                users.add( mUser.getmUserList().get(i));
                            }
                        }
                    }
                }


                mGroupe.setmUsers(users);
                List<Groupe> newGroupes = addGroupe();
                //Log.d("myTag",mGroupeBank.toString() );
                //List<Groupe> grouper = mGroupeBank.getmGroupeList();
                //grouper.add(mGroupe);
                //mGroupeBank.setmGroupeList(grouper);
                Toast.makeText(getApplicationContext(),"Groupe added",Toast.LENGTH_SHORT).show();
                Intent groupActivityIntent = new Intent(NewGroupActivity.this,GroupActivity.class);
                groupActivityIntent.putExtra("MyNewGroup", (Serializable) newGroupes);
                startActivity(groupActivityIntent);

            }});
    }
    protected UserBank getUsers(){
        User user1;
        user1 = new User("Lia", "12345678");
        User user2;
        user2 = new User("Nabil", "87654321");
        User user3 = new User("Etienne", "1234");

        UserBank allGroupes =  new UserBank(asList(user1,
                user2,
                user3));
        return allGroupes;

    }
    protected List<Groupe> addGroupe(){
        List<Groupe> groupesBank = mGroupeBank;
        groupesBank.add(mGroupe);
        return groupesBank;

    }






}