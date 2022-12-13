package com.example.muscle_studio_100;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ForgotpwdActivity extends AppCompatActivity {
    DBHelper db;
    Button reset;
    EditText fuser,fpwd,frepwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgotpwd);

        //Declaration des composants
        fuser=(EditText) findViewById(R.id.fgtusername);
        fpwd=findViewById(R.id.fpassword);
        frepwd=findViewById(R.id.fRepassword);
        reset=findViewById(R.id.resetbtn);


        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Verifier();
            }
        });
    }

    private void Verifier() {
        String user = fuser.getText().toString();
        String pwd = fpwd.getText().toString();
        String repwd = frepwd.getText().toString();
        db = new DBHelper(this);
        if(user.isEmpty())
        {
            showError(fuser,"Username is empty !");
        }
        else if(pwd.isEmpty() || pwd.length()<8)
        {
            showError(fpwd , "New Password field must have 8 characters !");

        }
        else if(repwd.isEmpty()|| repwd.equals(pwd)==false)
        {
            showError(frepwd , "Confirm Password field does not match the password field !");
        }

        else
        {
           Boolean kayn_user = db.checkusername(user);
           Boolean kayn_acc = db.checkUsernamePassword(user,pwd);

            if(kayn_user == false)
            {
                showError(fuser , "This user doesn't exist !");
            }
            else{
                db.updatePass(user , pwd);

                Toast.makeText(this, "Password updated successfully", Toast.LENGTH_SHORT).show();
            }
            if(kayn_acc)
            {
                showError(fpwd,"This password already used by "+user+" .");
                Toast.makeText(this, "Please go back and log in ", Toast.LENGTH_SHORT).show();
            }

        }
    }

    private void showError(EditText input, String s) {
        input.setError(s);
        input.requestFocus();
    }


}