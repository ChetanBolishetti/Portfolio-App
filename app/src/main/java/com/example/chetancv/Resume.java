package com.example.chetancv;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Resume extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resume);

        BottomNavigationView bv = findViewById(R.id.bottom_nav);
        bv.setSelectedItemId(R.id.dashboard);

        bv.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId())
                {
                    case R.id.home:
                        startActivity(new Intent(getApplicationContext(),NavBar.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.dashboard:
                        return true;

                    case R.id.about:
                        startActivity(new Intent(getApplicationContext(),about.class));
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });
    }


    public void resu(View view) {
        Intent i = new Intent(Resume.this, CV.class);
        startActivity(i);
    }

    public void link(View view) {
        Intent i = new Intent(Resume.this, Linkdin.class);
        startActivity(i);
    }


    public void popup(View view) {
        Intent i = new Intent(Resume.this, pop_up_window.class);
        startActivity(i);
    }
}
