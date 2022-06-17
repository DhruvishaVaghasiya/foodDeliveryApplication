package com.example.foodsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class ProfilePageActivity extends AppCompatActivity {

   EditText pnumEdt,emailEdt,urNameEdt,nameEdt,pinnumEdt;
    ImageView backIcon,checkIcon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_page);

        initView();
    }

    private void initView() {
        pnumEdt=findViewById(R.id.pnumEdt);
        emailEdt=findViewById(R.id.emailEdt);
        urNameEdt=findViewById(R.id.urNameEdt);
        nameEdt=findViewById(R.id.nameEdt);
        nameEdt=findViewById(R.id.pinnumEdt);

        String phoneNum = pnumEdt.getText().toString();
        String email = emailEdt.getText().toString();
        String userName = urNameEdt.getText().toString();
        String name = nameEdt.getText().toString();
        String PinNum = pinnumEdt.getText().toString();


        checkIcon=findViewById(R.id.checkIcon);
        backIcon = findViewById(R.id.backIcon);

        backIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ProfilePageActivity.this, HomePageActivity.class);
                startActivity(i);
            }
        });

        checkIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (name.isEmpty()) {
                    Toast.makeText(ProfilePageActivity.this, "PLEASE ENTER YOUR FIRST NAME", Toast.LENGTH_SHORT).show();
                } else if (name.length() > 15 && name.length() < 6) {
                    Toast.makeText(ProfilePageActivity.this, "ENTER CORRECT  FIRST NAME", Toast.LENGTH_SHORT).show();
                } else if (userName.isEmpty()) {
                    Toast.makeText(ProfilePageActivity.this, "PLEASE ENTER YOUR LAST NAME", Toast.LENGTH_SHORT).show();
                } else if (userName.length() > 16 && userName.length() < 6) {
                    Toast.makeText(ProfilePageActivity.this, " ENTER CORRECT LAST NAME", Toast.LENGTH_SHORT).show();
                } else if (email.isEmpty()) {
                    Toast.makeText(ProfilePageActivity.this, "PLEASE ENTER YOUR EMAIL", Toast.LENGTH_SHORT).show();
                } else if (phoneNum.isEmpty()) {
                    Toast.makeText(ProfilePageActivity.this, "PLEASE ENTER YOUR PHONE NUMBER", Toast.LENGTH_SHORT).show();
                } else if (phoneNum.length() < 10 && phoneNum.length() > 10) {
                    Toast.makeText(ProfilePageActivity.this, " ENTER YOUR CORRECT PHONE NUMBER", Toast.LENGTH_SHORT).show();
                } else if (PinNum.isEmpty()) {
                    Toast.makeText(ProfilePageActivity.this, "PLEASE ENTER YOUR PINCODE NUMBER", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(ProfilePageActivity.this, "SUCCESS", Toast.LENGTH_SHORT).show();

                    Intent i = new Intent(ProfilePageActivity.this, HomePageActivity.class);
                    startActivity(i);
                }
            }
        });
    }
}