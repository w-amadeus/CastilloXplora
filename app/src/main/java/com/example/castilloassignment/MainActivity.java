package com.example.castilloassignment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.castilloassignment.db.ConstructorPDVs;
import com.example.castilloassignment.db.ConstructorUsuarios;
import com.example.castilloassignment.pojo.PDV;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Animation topAnim, bottomAnim;
    ImageView ivSplash;
    TextView tvSplash, tvSplashAppVer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        topAnim = AnimationUtils.loadAnimation(this, R.anim.top_animation);
        bottomAnim = AnimationUtils.loadAnimation(this, R.anim.bottom_animation);

        ivSplash = findViewById(R.id.ivSplash);
        tvSplash = findViewById(R.id.tvSplash);
        tvSplashAppVer = findViewById(R.id.tvSplashAppVer);

        ivSplash.setAnimation(topAnim);
        tvSplash.setAnimation(bottomAnim);
        tvSplashAppVer.setAnimation(bottomAnim);

        new Handler().postDelayed(new Runnable() {
            @Override public void run() {
                Intent startActivity = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(startActivity);
                finish(); } }, 2000);


        ConstructorUsuarios constructorUsuarios = new ConstructorUsuarios(this);
        constructorUsuarios.obtenerDatos();


    }


}