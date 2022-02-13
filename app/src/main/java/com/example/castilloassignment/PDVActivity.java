package com.example.castilloassignment;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class PDVActivity extends AppCompatActivity {

    String[] permissions = {"android.permission.CAMERA"};

    TextView tvName;
    TextView tvLocation;

    Button btnVisit;
    ImageButton ibPhoto;

    ImageView ivPDV;

    private String name;
    private String location;

    private int logo;
    private  int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdv);

        tvName = (TextView) findViewById(R.id.tvName);
        tvLocation = (TextView) findViewById(R.id.tvLocation);

        btnVisit = (Button) findViewById(R.id.btnVisit);
        ibPhoto = (ImageButton) findViewById(R.id.ibPhoto);

        ivPDV = (ImageView) findViewById(R.id.ivPDV);

        Intent intent = getIntent();
        name = intent.getStringExtra("name");
        location = intent.getStringExtra("location");
        logo = intent.getIntExtra("logo", 0);
        id = intent.getIntExtra("id", 0);


        tvName.setText(name);
        tvLocation.setText(location);

        ivPDV.setImageResource(logo);

        btnVisit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent passToList = new Intent(view.getContext(), ListActivity.class);
                passToList.putExtra("id", id);
                startActivity(passToList);

            }
        });

        ibPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M)
                {
                    requestPermissions(permissions, 80);
                }

                Intent intentPhoto = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intentPhoto, 101);

            }
        });

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if(requestCode == 80){

            if(grantResults[0] == PackageManager.PERMISSION_GRANTED){

                Toast.makeText(this, "Si", Toast.LENGTH_LONG).show();
            }
            else {

                Toast.makeText(this, "No", Toast.LENGTH_LONG).show();
            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 101){

            Bitmap bitmap = (Bitmap) data.getExtras().get("data");
            ibPhoto.setImageBitmap(bitmap);
        }
    }
}