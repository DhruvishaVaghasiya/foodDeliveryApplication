package com.example.foodsapp.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.foodsapp.R;

import de.hdodenhof.circleimageview.CircleImageView;

public class SushiPageActivity extends AppCompatActivity {
    TextView txtOrder;
    CircleImageView proFilePic;
    LinearLayout pizzaClick,burgerClick,sushiClick;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sushi_page);

        proFilePic=findViewById(R.id.proFilePic);
        txtOrder=findViewById(R.id.txtOrder);
        pizzaClick=findViewById(R.id.pizzaClick);
        burgerClick=findViewById(R.id.burgerClick);
        sushiClick=findViewById(R.id.sushiClick);

        initView();
    }

    private void initView() {

        txtOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(SushiPageActivity.this,OrderPageActivity.class);
                startActivity(i);
            }
        });

        pizzaClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(SushiPageActivity.this,HomePageActivity.class);
                startActivity(i);
            }
        });
        burgerClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(SushiPageActivity.this,BurgerPageActivity.class);
                startActivity(i);
            }
        });

        sushiClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(SushiPageActivity.this,SushiPageActivity.class);
                startActivity(i);
            }
        });
        proFilePic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(SushiPageActivity.this,ProfilePageActivity.class);
                startActivity(intent);
            }
        });
    }
}