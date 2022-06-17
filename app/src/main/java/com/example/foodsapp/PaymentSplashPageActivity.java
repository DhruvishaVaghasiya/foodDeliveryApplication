package com.example.foodsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class PaymentSplashPageActivity extends AppCompatActivity {

    ImageView nextIcon;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_splash_page);

        nextIcon=findViewById(R.id.nextIcon);

        nextIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(PaymentSplashPageActivity.this,  MainActivity.class);
                startActivity(i);
            }
        });
    }
}