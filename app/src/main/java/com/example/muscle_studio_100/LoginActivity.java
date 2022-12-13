package com.example.muscle_studio_100;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class LoginActivity extends AppCompatActivity {
    //Declaration des composants d'activité :
    TextView signIntxt , forgotPwd ;
    Button LogInbtn ;
    EditText Input_username , Input_password ;
    ProgressBar p ;
    DBHelper db ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //Affectation des composants
        Input_username = findViewById(R.id.username);
        Input_password = findViewById(R.id.loginpwd);
        signIntxt = findViewById(R.id.SignInTxtView);
        LogInbtn = findViewById(R.id.loginbtn);
        p=(ProgressBar) findViewById(R.id.progressBar2);
        forgotPwd =findViewById(R.id.forgotpwd);

        signIntxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent RegisterIntent = new Intent(LoginActivity.this , RegisterActivity.class);
                startActivity(RegisterIntent);
            }
        });

        forgotPwd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ForgotPwdActivity= new Intent(LoginActivity.this , ForgotpwdActivity.class);
                startActivity(ForgotPwdActivity);
            }
        });

        LogInbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Verifier();
            }
        });


    }
    public void Verifier()
    {
        String user = Input_username.getText().toString();
        String pwd = Input_password.getText().toString();

        if(user.isEmpty())
        {
            showError(Input_username,"Username is empty !");
        }
        else if(pwd.isEmpty())
        {
            showError(Input_password , "Password field is empty !");

        }
        else
        {
            //Montrer un chargement d'écran
            p.setVisibility(View.VISIBLE);

            //Verifer l'existance du compte
            db=new DBHelper(this);
            Boolean checkUsernamePass = db.checkUsernamePassword(user,pwd);
            if(checkUsernamePass){

                Toast.makeText(this, "Authentification Succeeded", Toast.LENGTH_SHORT).show();
                Toast.makeText(this, "Welcome", Toast.LENGTH_SHORT).show();

                //Envoyer le nom d'utilisateur
                Intent offersIntent = new Intent(LoginActivity.this , OffersActivity.class);
                offersIntent.putExtra("profile" , user);
              //  Allez à la vue prochaine
                startActivity(offersIntent);
            }else {

                Toast.makeText(this, "Authentofication failed", Toast.LENGTH_SHORT).show();

                startActivity(new Intent(LoginActivity.this , LoginActivity.class));
                Toast.makeText(this, "Try again or register", Toast.LENGTH_SHORT).show();
            }

        }
    }
    public void  showError(EditText input ,String s)
    {
        input.setError(s);
        input.requestFocus();
    }
}