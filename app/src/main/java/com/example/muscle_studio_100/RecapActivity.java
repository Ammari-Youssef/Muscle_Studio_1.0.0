package com.example.muscle_studio_100;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class RecapActivity extends AppCompatActivity {

    Button validatebtn, editbtn;

    TextView coach_recap, offer_submode;
    DBHelper db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recap);

        Intent i = getIntent();

        coach_recap = findViewById(R.id.ChosenCoachRecap);
        offer_submode = findViewById(R.id.ModeSubRecap);

        validatebtn = findViewById(R.id.RecapValidatebtn);
        editbtn = findViewById(R.id.RecapEditBtn);

        //Recevoir les donnees d'autre activités
        String submode = i.getStringExtra("Subscription_Offer");
        String coachname = i.getStringExtra("Coach");
        String username = i.getStringExtra("profile");

        //
        offer_submode.setText(submode);
        if (coachname != null) {
            coach_recap.setText(coachname);
        }
        else {
            coach_recap.setText("No coach selected");
        }

        validatebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                enroll(username);
            }
        });

        editbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent restartApp = new Intent(RecapActivity.this, OffersActivity.class);
                startActivity(restartApp);

            }
        });
    }

    public void enroll(String user) {
        db = new DBHelper(this);

        String co = coach_recap.getText().toString();
        String sm = offer_submode.getText().toString();

        Boolean recapdatainserted = db.UpdateRecapData(user, sm, co);

        if (recapdatainserted == true) {
            Toast.makeText(this, user + " your activities has been saved", Toast.LENGTH_SHORT).show();

            Toast.makeText(this, "Thank you for choosing us ", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(RecapActivity.this , TimeTableActivity.class));
        } else {
            Toast.makeText(this, "Something went wrong ", Toast.LENGTH_SHORT).show();
        }
    }
}