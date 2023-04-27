package com.example.shayariapp;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.shayariapp.Fragments.AttitudeFragments;
import com.example.shayariapp.Fragments.Haryanvi_Fragment;
import com.example.shayariapp.Fragments.Love;
import com.example.shayariapp.Fragments.SadFragment;
import com.example.shayariapp.Fragments.Settings;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {
    com.google.android.material.bottomnavigation.BottomNavigationView navigationView;
    FrameLayout frameLayout;
    private static int FLAG = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        navigationView = findViewById(R.id.navigationView);
        //LoadingBar loadingBar=   new LoadingBar(this);
        // loadingBar.loadDailoge();

        fr(new Love(), FLAG);
        //loadingBar.cancleDailoge();

        navigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                FLAG = 2;
                if (item.getItemId() == R.id.love) {
                    //Toast.makeText(MainActivity.this, "Love", Toast.LENGTH_SHORT).show();

                    fr(new Love(), FLAG);

                } else if (item.getItemId() == R.id.sad) {

                    fr(new SadFragment(), FLAG);
                } else if (item.getItemId() == R.id.Attitude) {

                    fr(new AttitudeFragments(), FLAG);
                } else if (item.getItemId() == R.id.haryanvi) {
                    fr(new Haryanvi_Fragment(), FLAG);

                } else {
                    fr(new Settings(), FLAG);
                   // Toast.makeText(MainActivity.this, "Settings", Toast.LENGTH_SHORT).show();
                }
                return true;
            }
        });

    }

    private void fr(Fragment fr, int flag) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction tr = fm.beginTransaction();
        if (flag == 1) {
            tr.add(R.id.frame, fr, "default");
            tr.commit();
            navigationView.setSelected(true);
            navigationView.setSelectedItemId(R.id.attitudeId);

        } else {
            tr.replace(R.id.frame, fr, "love");
            tr.commit();

        }
        navigationView.setSelected(false);
       // navigationView.dispatchSetSelected(true);

        SharedPreferences sharedPreferences = getSharedPreferences("MODE", MODE_PRIVATE);
        int NIGHT_MODE_CHECk = sharedPreferences.getInt("MODE", 1);
        AppCompatDelegate.setDefaultNightMode(NIGHT_MODE_CHECk);
    }

}