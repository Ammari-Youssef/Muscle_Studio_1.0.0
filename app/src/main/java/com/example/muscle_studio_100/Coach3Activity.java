package com.example.muscle_studio_100;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Coach3Activity extends AppCompatActivity {
    TextView NmCoach;
    Button hireC;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coach3);


        hireC=findViewById(R.id.HireC);
        NmCoach=findViewById(R.id.coachName);

        hireC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Recevoir les donnees
                Intent a = getIntent();
                String user = a.getStringExtra("profile");
                String offer = a.getStringExtra("Subscription_Offer");
                //Les envoyer au vue suivante avec le nom du coach
                Intent addtorecap = new Intent(Coach3Activity.this, RecapActivity.class);
                addtorecap.putExtra("Coach", NmCoach.getText().toString());
                addtorecap.putExtra("profile", user);
                addtorecap.putExtra("Subscription_Offer", offer);

                Toast.makeText(Coach3Activity.this, "You have chosen the third coach.", Toast.LENGTH_SHORT).show();
                startActivity(addtorecap);
            }
        });

    }
}