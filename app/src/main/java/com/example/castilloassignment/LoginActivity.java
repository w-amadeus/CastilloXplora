package com.example.castilloassignment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.example.castilloassignment.db.ConstructorUsuarios;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;

public class LoginActivity extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager viewPager;
    FloatingActionButton btnFb, btnGoogle, btnTwitter;
    float v;

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


    }
}