package com.example.chetancv;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class about extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        BottomNavigationView bv = findViewById(R.id.bottom_nav);
        bv.setSelectedItemId(R.id.about);

        bv.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId())
                {
                    case R.id.home:
                        startActivity(new Intent(getApplicationContext(),NavBar.class));
                        overridePendingTransition(0,0);
                        finish();
                        return true;

                    case R.id.dashboard:
                        startActivity(new Intent(getApplicationContext(),Resume.class));
                        overridePendingTransition(0,0);
                        finish();
                        return true;

                    case R.id.about:
                        return true;
                }
                return false;
            }
        });

    }
}
