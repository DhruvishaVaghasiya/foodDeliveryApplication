package com.example.foodsapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import de.hdodenhof.circleimageview.CircleImageView;

public class HomePageActivity extends AppCompatActivity {

    TextView txtOrder;
    CircleImageView proFilePic;
    LinearLayout pizzaClick, burgerClick, sushiClick, meatPizza;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);


        proFilePic = findViewById(R.id.proFilePic);
        txtOrder = findViewById(R.id.txtOrder);
        pizzaClick = findViewById(R.id.pizzaClick);
        burgerClick = findViewById(R.id.burgerClick);
        sushiClick = findViewById(R.id.sushiClick);
        meatPizza = findViewById(R.id.meatPizza);


        initView();
    }

    private void initView() {
        txtOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(HomePageActivity.this, OrderPageActivity.class);
                startActivity(i);
            }
        });

        pizzaClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(HomePageActivity.this, HomePageActivity.class);
                startActivity(i);
            }
        });
        burgerClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(HomePageActivity.this, BurgerPageActivity.class);
                startActivity(i);
            }
        });
        sushiClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(HomePageActivity.this, SushiPageActivity.class);
                startActivity(i);
            }
        });

        meatPizza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(HomePageActivity.this, PizzaDetailActivity.class);
                startActivity(i);
            }
        });

        proFilePic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomePageActivity.this, ProfilePageActivity.class);
                startActivity(intent);
            }
        });

    }

    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(HomePageActivity.this);
        builder.setTitle("Exit Alert");
        builder.setMessage("Are you sure you want to exit?");

        builder.setPositiveButton("yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                HomePageActivity.this.finish();
            }
        });

        builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });

        AlertDialog d = builder.create();
        d.setCancelable(false);
        d.show();

    }
}