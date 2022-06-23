package com.example.foodsapp.activity;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.foodsapp.R;
import com.example.foodsapp.databinding.ActivityProfilePageBinding;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.io.File;
import java.io.IOException;

public class ProfilePageActivity extends AppCompatActivity {


    int GELLERY_PICK = 100, CAMERA_PICK = 110;
    Uri imageUri;
    ActivityProfilePageBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityProfilePageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        initView();
    }

    private void initView() {


        openGallery();
        String phoneNum = binding.pnumEdt.getText().toString();
        String email = binding.emailEdt.getText().toString();
        String userName = binding.urNameEdt.getText().toString();
        String name = binding.nameEdt.getText().toString();
        String PinNum = binding.pinnumEdt.getText().toString();


        binding.backIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ProfilePageActivity.this, HomePageActivity.class);
                startActivity(i);
            }
        });

        binding.checkIcon.setOnClickListener(new View.OnClickListener() {
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
                } else {
                    Toast.makeText(ProfilePageActivity.this, "SUCCESS", Toast.LENGTH_SHORT).show();

                    Intent i = new Intent(ProfilePageActivity.this, HomePageActivity.class);
                    startActivity(i);
                }
            }
        });
    }

    private void openGallery() {

        binding.changeProFilePic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDialogBox();
            }


        });


    }

    private void openDialogBox() {
        BottomSheetDialog d = new BottomSheetDialog(ProfilePageActivity.this);
        d.setContentView(R.layout.dialogbox_items);

        Window w = d.getWindow();
        //  d.getWindow().setSoftInputMode(android.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        w.setLayout(ActionBar.LayoutParams.MATCH_PARENT, ActionBar.LayoutParams.WRAP_CONTENT);

        ImageView camera = (ImageView) d.findViewById(R.id.camera);

        camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent camera_intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                // Start the activity with camera_intent,
                startActivityForResult(camera_intent, CAMERA_PICK);
                d.dismiss();

            }
        });


        ImageView gallery = (ImageView) d.findViewById(R.id.gallery);
        gallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                i.setType("image/*");
                i.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(i, GELLERY_PICK);
                d.dismiss();
            }
        });
        AppCompatButton cancelBtn = (AppCompatButton) d.findViewById(R.id.cancelBtn);

        cancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                d.dismiss();
            }
        });
        d.setCancelable(false);
        d.show();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.e("TAG", "onActivityResult: " + requestCode + "=" + resultCode + "=" + data);

        if (requestCode == GELLERY_PICK && resultCode == RESULT_OK) {
            Uri selectedImageUri = data.getData();
            if (null != selectedImageUri) {
                // update the preview image in the layout
                binding.proFilePic.setImageURI(selectedImageUri);
            }
        } else if (requestCode == CAMERA_PICK && resultCode == RESULT_OK) {

            // BitMap is data structure of image file
            // which store the image in memory
            Bitmap photo = (Bitmap) data.getExtras().get("data");
            // Set the image in imageview for display
            binding.proFilePic.setImageBitmap(photo);
        }
    }


}
