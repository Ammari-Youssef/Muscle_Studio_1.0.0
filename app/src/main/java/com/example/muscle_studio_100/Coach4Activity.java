package com.example.muscle_studio_100;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Coach4Activity extends AppCompatActivity {

    TextView NmCoach;
    Button hireC;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coach4);
        hireC=findViewById(R.id.HireC);
        NmCoach=findViewById(R.id.coachName);

        hireC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent addtorecap = new Intent(Coach4Activity.this , RecapActivity.class);
                addtorecap.putExtra("Coach" , NmCoach.getText().toString());
                Toast.makeText(Coach4Activity.this, "You can see this coach in Recap field", Toast.LENGTH_SHORT).show();
            }
        });

    }
}