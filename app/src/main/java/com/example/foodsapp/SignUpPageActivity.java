package com.example.foodsapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class SignUpPageActivity extends AppCompatActivity {

    TextView loginTxt;
    AppCompatButton signBtn;
    EditText nameEdt, emailEdt, passwordEdt;
    String Name, Email, Password;
    ImageView backIcon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_page);

        initSignupView();

    }

    private void initSignupView() {
        loginTxt = findViewById(R.id.loginTxt);
        signBtn = findViewById(R.id.signBtn);
        nameEdt = findViewById(R.id.nameEdt);
        emailEdt = findViewById(R.id.emailEdt);
        passwordEdt = findViewById(R.id.passwordEdt);
        backIcon = findViewById(R.id.backIcon);

        backIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(SignUpPageActivity.this, LoginPageActivity.class);
                startActivity(i);
            }

        });


        loginTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(SignUpPageActivity.this, LoginPageActivity.class);
                startActivity(i);
            }
        });
        signBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Name = nameEdt.getText().toString();
                String Email = emailEdt.getText().toString();
                String Password = passwordEdt.getText().toString();

                if (Name.isEmpty()) {
                    Toast.makeText(SignUpPageActivity.this, "PLEASE ENTER YOUR FIRST NAME", Toast.LENGTH_SHORT).show();
                } else if (Name.length() > 15 && Name.length() < 6) {
                    Toast.makeText(SignUpPageActivity.this, "ENTER CORRECT  FIRST NAME", Toast.LENGTH_SHORT).show();
                } else if (Email.isEmpty()) {
                    Toast.makeText(SignUpPageActivity.this, "PLEASE ENTER YOUR EMAIL ID", Toast.LENGTH_SHORT).show();
                } else if (Email.length() > 15 && Email.length() < 6) {
                    Toast.makeText(SignUpPageActivity.this, "ENTER CORRECT EMAIL ID", Toast.LENGTH_SHORT).show();
                } else if (Password.isEmpty()) {
                    Toast.makeText(SignUpPageActivity.this, "PLEASE ENTER YOUR PASSWORD", Toast.LENGTH_SHORT).show();
                } else if (Password.length() > 15 && Password.length() < 6) {
                    Toast.makeText(SignUpPageActivity.this, "ENTER CORRECT  PASSWORD", Toast.LENGTH_SHORT).show();
                } else {

                    Intent i = new Intent(SignUpPageActivity.this, DeliciousSplashPage.class);
                    startActivity(i);
                }
            }
        });
    }
}