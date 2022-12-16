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

        subbtn=findViewById(R.id.subscribebtn);

        subbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent addToRecapOffer = new Intent(Offer1Activity.this , RecapActivity.class);
                addToRecapOffer.putExtra("Subscription_Offer","Yearly");
                Intent coaches = new Intent(Offer1Activity.this , CoachesActivity.class);
                startActivity(coaches);
                Toast.makeText(Offer1Activity.this, "You have chosen the yearly subscription", Toast.LENGTH_SHORT).show();
            }
        });
    }
}