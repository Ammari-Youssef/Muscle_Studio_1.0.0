package com.example.muscle_studio_100;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Offer1Activity extends AppCompatActivity {


    Button subbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_offer1);

        subbtn = findViewById(R.id.subscribebtn);

        subbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Recevoir user
                Intent userIntent = getIntent();
                String user = userIntent.getStringExtra("profile");
                //Envoyer offer 1 et nom user
                Intent coaches = new Intent(Offer1Activity.this, CoachesActivity.class);
                coaches.putExtra("profile", user);
                coaches.putExtra("Subscription_Offer", "Yearly");

                Toast.makeText(Offer1Activity.this, "You have chosen the yearly subscription", Toast.LENGTH_SHORT).show();
                startActivity(coaches);
            }
        });
    }
}