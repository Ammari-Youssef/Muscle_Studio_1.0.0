package com.example.muscle_studio_100;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class OffersActivity extends AppCompatActivity {

    TextView txt;
    ListView lvo;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_offers);

        txt = findViewById(R.id.textView);

        lvo = findViewById(R.id.OffersListView);

        //Prendre le nom de l'intent precedante

        Intent intent = getIntent();

        String userIntent = intent.getStringExtra("profile");
        //txt.setText( userIntent + " Choose an offer");

        //Remplir et affichage la ListView
        ArrayList<Offer> arr = new ArrayList<>();

        arr.add(new Offer("Yearly", "900 MAD"));
        arr.add(new Offer("Six months", "480MAD"));
        arr.add(new Offer("Three months", "270MAD"));
        arr.add(new Offer("Monthly", "100MAD"));


        OfferAdapter ad = new OfferAdapter(this, R.layout.offer_item, arr);
        lvo.setAdapter(ad);
        //Choisir un seul type d'abonnement


        lvo.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                switch (position) {
                    case 0:
                        Intent o1=new Intent(OffersActivity.this , Offer1Activity.class);
                        o1.putExtra("profile",userIntent);
                        startActivity(o1);
                        break;
                    case 1:
                        Intent o2=new Intent(OffersActivity.this , Offer2Activity.class);
                        o2.putExtra("profile",userIntent);
                        startActivity(o2);
                        break;
                    case 2:
                        Intent o3=new Intent(OffersActivity.this , Offer3Activity.class);
                        o3.putExtra("profile",userIntent);
                        startActivity(o3);

                        break;
                    case 3:
                        Intent o4=new Intent(OffersActivity.this , Offer4Activity.class);
                        o4.putExtra("profile",userIntent);
                        startActivity(o4);

                        break;

                }

            }
        });


    }



}