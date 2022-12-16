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

        //Creer les informations
        ArrayList<Coach> arraytest = new ArrayList<>();

        arraytest.add(new Coach(R.drawable.coach1, "Jamal Rochdi", "Age:33  Prix : 200DH"));
        arraytest.add(new Coach(R.drawable.coach2, "Youssef Ghasi ", "Age:25  Prix : 200DH"));
        arraytest.add(new Coach(R.drawable.coach3, "George Johnson", "Age:27  Prix : 200DH"));
        arraytest.add(new Coach(R.drawable.coach4, "Yassine Abad", "Age:21  Prix : 200DH"));
        arraytest.add(new Coach(R.drawable.coach3, "Robert Davis", "Age:33  Prix : 200DH"));


        //Adaptateur Modifié
        CoachAdapter adapter = new CoachAdapter(this, R.layout.coach_row, arraytest);
        lvc.setAdapter(adapter);


        //Selection de l'item et acceder a l'interface correspond le coach .
        lvc.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                switch (position)
                {
                    case 0:
                        startActivity(new Intent(CoachesActivity.this ,Coach1Activity.class ));
                        break;

                    case 1:
                        startActivity(new Intent(CoachesActivity.this ,Coach2Activity.class ));
                        break;

                    case 2:
                        startActivity(new Intent(CoachesActivity.this ,Coach3Activity.class ));
                        break;

                    case 3:
                        startActivity(new Intent(CoachesActivity.this ,Coach4Activity.class ));
                        break;

                    case 4:
                        startActivity(new Intent(CoachesActivity.this ,Coach5Activity.class ));
                        break;

                }


            }
        });

        noCoachbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goTOrecap=new Intent(CoachesActivity.this , RecapActivity.class);
                goTOrecap.putExtra("NoCoach","null");
                startActivity(goTOrecap);
            }
        });
    }


}