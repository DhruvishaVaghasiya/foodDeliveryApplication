package com.example.foodsapp.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.foodsapp.R;

public class DeliciousSplashPage extends AppCompatActivity {
    ImageView nextIcon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delicious_splash_page);

        nextIcon=findViewById(R.id.nextIcon);

        nextIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(DeliciousSplashPage.this,  ShippingSplashPageActivity.class);
                startActivity(i);
            }
        });
    }
}