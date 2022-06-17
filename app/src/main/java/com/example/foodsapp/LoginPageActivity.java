package com.example.foodsapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginPageActivity extends AppCompatActivity {

    TextView signUpTxt;
    AppCompatButton loginBtn;
    EditText userEdt,passwordEdt;
    String UserName,Password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

        initLoginView();
    }

    private void initLoginView() {
        signUpTxt=findViewById(R.id.signUpTxt);
        loginBtn=findViewById(R.id.loginBtn);
        userEdt=findViewById(R.id.userEdt);
        passwordEdt=findViewById(R.id.passwordEdt);

        signUpTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(LoginPageActivity.this,SignUpPageActivity.class);
                startActivity(i);
            }
        });
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String UserName = userEdt.getText().toString();
                String Password = passwordEdt.getText().toString();

                if (UserName.isEmpty()) {
                    Toast.makeText(LoginPageActivity.this, "PLEASE ENTER YOUR USERNAME OR EMAIL", Toast.LENGTH_SHORT).show();
                } else if (UserName.length() > 15) {
                    Toast.makeText(LoginPageActivity.this, "ENTER CORRECT USERNAME OR EMAIL", Toast.LENGTH_SHORT).show();
                }  else if ( UserName.length() < 6) {
                    Toast.makeText(LoginPageActivity.this, "ENTER CORRECT USERNAME OR EMAIL", Toast.LENGTH_SHORT).show();
                } else if (Password.isEmpty()) {
                        Toast.makeText(LoginPageActivity.this, "PLEASE ENTER YOUR PASSWORD", Toast.LENGTH_SHORT).show();
                    } else if (Password.length() <= 6) {
                        Toast.makeText(LoginPageActivity.this, "ENTER CORRECT PASSWORD", Toast.LENGTH_SHORT).show();
                    } else {
                        Intent i = new Intent(LoginPageActivity.this, DeliciousSplashPage.class);
                        startActivity(i);
                    }
                }
        });
    }

}