package com.example.muscle_studio_100;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Coach5Activity extends AppCompatActivity {
    TextView NmCoach;
    Button hireC;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coach5);

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
                Intent addtorecap = new Intent(Coach5Activity.this, RecapActivity.class);
                addtorecap.putExtra("Coach", NmCoach.getText().toString());
                addtorecap.putExtra("profile", user);
                addtorecap.putExtra("Subscription_Offer", offer);

                Toast.makeText(Coach5Activity.this, "You have chosen the fifth coach.", Toast.LENGTH_SHORT).show();
                startActivity(addtorecap);
            }
        });
    }
}