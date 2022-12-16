package com.example.muscle_studio_100;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class CoachesActivity extends AppCompatActivity {

    ListView lvc;
    Button noCoachbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coaches);

        lvc = findViewById(R.id.ListViewCoaches);
        noCoachbtn = findViewById(R.id.NoCoachBtn);

        //Information de l'abonnement recu

        Intent t = getIntent();
        String offer = t.getStringExtra("Subscription_Offer");
        String user =t.getStringExtra("profile");
        //Creer les informations de listview
        ArrayList<Coach> arraytest = new ArrayList<>();

        arraytest.add(new Coach(R.drawable.coach1, "Jamal Rochdi", "Age:33  Prix : 200DH"));
        arraytest.add(new Coach(R.drawable.coach2, "Youssef Ghasi ", "Age:25  Prix : 200DH"));
        arraytest.add(new Coach(R.drawable.coach3, "George Johnson", "Age:27  Prix : 200DH"));
        arraytest.add(new Coach(R.drawable.coach4, "Yassine Abad", "Age:34  Prix : 200DH"));
        arraytest.add(new Coach(R.drawable.coach5, "Robert Davis", "Age:33  Prix : 200DH"));


        //Adaptateur Modifié
        CoachAdapter adapter = new CoachAdapter(this, R.layout.coach_row, arraytest);
        lvc.setAdapter(adapter);


        //Selection de l'item et acceder a l'interface correspond le coach .
        lvc.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                switch (position) {
                    case 0:
                        Intent c1 =new Intent(CoachesActivity.this, Coach1Activity.class);
                        c1.putExtra("Subscription_Offer" ,offer);
                        c1.putExtra("profile" ,user);
                        startActivity(c1);
                        break;

                    case 1:
                        Intent c2 =new Intent(CoachesActivity.this, Coach2Activity.class);
                        //Envoyer nom user et offer
                        c2.putExtra("Subscription_Offer" ,offer);
                        c2.putExtra("profile",user);
                        startActivity(c2);
                        break;

                    case 2:
                        Intent c3 =new Intent(CoachesActivity.this, Coach3Activity.class);
                        //Envoyer nom user et offer
                        c3.putExtra("Subscription_Offer" ,offer);
                        c3.putExtra("profile",user);
                        startActivity(c3);
                        break;

                    case 3:
                        Intent c4 =new Intent(CoachesActivity.this, Coach4Activity.class);
                        //Envoyer nom user et offer
                        c4.putExtra("profile",user);
                        c4.putExtra("Subscription_Offer" ,offer);
                        startActivity(c4);
                        break;

                    case 4:
                        Intent c5 =new Intent(CoachesActivity.this, Coach5Activity.class);
                        //Envoyer nom user et offer
                        c5.putExtra("Subscription_Offer" ,offer);
                        c5.putExtra("profile",user);

                        startActivity(c5);
                        break;

                }


            }
        });

//TODO: verifi hadi wach tkhdm
        noCoachbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goTOrecap = new Intent(CoachesActivity.this, RecapActivity.class);
                goTOrecap.putExtra("NoCoach", "null");
                startActivity(goTOrecap);
            }
        });


    }


}