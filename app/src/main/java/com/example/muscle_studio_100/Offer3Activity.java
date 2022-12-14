package com.example.muscle_studio_100;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Offer3Activity extends AppCompatActivity {

    Button subbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_offer3);

        subbtn=findViewById(R.id.subscribebtn);

        subbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent addToRecapOffer = new Intent(Offer3Activity.this , RecapActivity.class);
                addToRecapOffer.putExtra("Subscription_Offer","Three months");
                startActivity(addToRecapOffer);
                Toast.makeText(Offer3Activity.this, "You have chosen the yearly subscription", Toast.LENGTH_SHORT).show();
            }
        });
    }
}