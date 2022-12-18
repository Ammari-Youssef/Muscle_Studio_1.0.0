package com.example.muscle_studio_100;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {
        //Declaration des composants
        TextView signUptxt ;
        EditText InputUsername , InputPassword ,InputRepassword ;
        Button SignInbtn;
        DBHelper DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        //Affectation
        InputUsername=findViewById(R.id.SignInUser);
        InputPassword=findViewById(R.id.SignInPwd);
        InputRepassword=findViewById(R.id.SignInRepwd);

        signUptxt= findViewById(R.id.SignUpTxtView);
        SignInbtn=findViewById(R.id.registerbtn);
        DB = new DBHelper(this);

        signUptxt.setOnClickListener(view -> {
            Intent LoginIntent = new Intent(RegisterActivity.this , LoginActivity.class);
            startActivity(LoginIntent);
        });

        SignInbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Verifier();
            }
        });
    }//fin Oncreate

    public void Verifier() {
        String user = InputUsername.getText().toString();
        String pwd = InputPassword.getText().toString();
        String Repwd = InputRepassword.getText().toString();
        //ProgressBar p = findViewById(R.id);
        if(user.isEmpty() || user.length() < 7)
        {
            showError(InputUsername,"Your username's length is less than 7 characters ");
        }
        else if(pwd.isEmpty() || pwd.length() < 8  )
        {
            showError(InputPassword , "Password's length is less than 8 characters !");
        }
        else if(Repwd.isEmpty() || !Repwd.equals(pwd))
        {
            showError(InputRepassword , "Confirmation field does not match password field !");
        }

        else {

                Boolean checkUser = DB.checkusername(user);
                if (checkUser==false) {
                    Boolean insert = DB.insertData(user, pwd);
                    if (insert==true) {
                        Toast.makeText(this, "Registration succeeded", Toast.LENGTH_SHORT).show();
                        Toast.makeText(this, "Welcome", Toast.LENGTH_SHORT).show();

                        Intent offersIntent = new Intent(RegisterActivity.this, OffersActivity.class);
                        startActivity(offersIntent);
                    } else {
                        Toast.makeText(this, "Registration failed", Toast.LENGTH_SHORT).show();
                        Toast.makeText(this, "Account created", Toast.LENGTH_SHORT).show();

                    }
                } else {
                    Toast.makeText(this, "User already exists , please sign in !", Toast.LENGTH_SHORT).show();
                }

            }

        }//Fin Verifier

    public void  showError(EditText input ,String s)
    {
        input.setError(s);
        input.requestFocus();
    }

}