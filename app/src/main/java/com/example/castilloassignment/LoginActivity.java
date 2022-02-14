package com.example.castilloassignment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.ViewPager;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;

import com.example.castilloassignment.db.ConstructorUsuarios;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;

public class LoginActivity extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager viewPager;
    FloatingActionButton btnFb, btnGoogle, btnTwitter;
    float v;
    private final  static  int REQUEST_CODE = 120;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        tabLayout = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.viewPager);
        btnFb = findViewById(R.id.fabFac);
        btnGoogle = findViewById(R.id.fabGoogle);
        btnTwitter = findViewById(R.id.fabTwitter);

        tabLayout.addTab(tabLayout.newTab().setText(R.string.login));
        tabLayout.addTab(tabLayout.newTab().setText(R.string.login_s));
        tabLayout.setTabGravity(tabLayout.GRAVITY_FILL);

        final LoginAdapter adapter = new LoginAdapter(getSupportFragmentManager(), this, tabLayout.getTabCount());
        viewPager.setAdapter(adapter);

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));


        btnFb.setTranslationY(300);
        btnGoogle.setTranslationY(300);
        btnTwitter.setTranslationY(300);
        tabLayout.setTranslationY(300);

        btnFb.setAlpha(v);
        btnGoogle.setAlpha(v);
        btnTwitter.setAlpha(v);
        tabLayout.setAlpha(v);

        btnFb.animate().translationY(0).alpha(1).setDuration(1000).setStartDelay(400).start();
        btnGoogle.animate().translationY(0).alpha(1).setDuration(1000).setStartDelay(600).start();
        btnTwitter.animate().translationY(0).alpha(1).setDuration(1000).setStartDelay(800).start();
        tabLayout.animate().translationY(0).alpha(1).setDuration(1000).setStartDelay(100).start();

        verifyPermissions();


    }

    private void verifyPermissions(){

        String[] permisions = {Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.CAMERA};

        if(ContextCompat.checkSelfPermission(this,
                permisions[0]) == PackageManager.PERMISSION_GRANTED &&
                ContextCompat.checkSelfPermission(this,
                        permisions[1]) == PackageManager.PERMISSION_GRANTED &&
                ContextCompat.checkSelfPermission(this,
                        permisions[2]) == PackageManager.PERMISSION_GRANTED
        )
        {

        }

        else{

            ActivityCompat.requestPermissions(this, permisions, REQUEST_CODE);

        }

    }
}