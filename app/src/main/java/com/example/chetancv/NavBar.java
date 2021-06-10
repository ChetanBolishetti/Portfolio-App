package com.example.chetancv;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class NavBar extends AppCompatActivity {

    DatabaseReference myref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nav_bar);
        ProgressBar propb = findViewById(R.id.propb);
        propb.setVisibility(View.VISIBLE);
        TextView proj1,proj2;
        proj1 = findViewById(R.id.proj1);
        proj2 = findViewById(R.id.proj2);
        BottomNavigationView bv = findViewById(R.id.bottom_nav);
        bv.setSelectedItemId(R.id.home);

        myref = FirebaseDatabase.getInstance().getReference().child("Data");
        myref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String pro1 = snapshot.child("project1").getValue().toString();
                String pro2 = snapshot.child("project2").getValue().toString();

                proj1.setText(pro1);
                proj2.setText(pro2);

                propb.setVisibility(View.INVISIBLE);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(NavBar.this,"Could't load data",Toast.LENGTH_LONG).show();
            }
        });

        bv.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId())
                {
                    case R.id.home:
                        return true;

                    case R.id.dashboard:
                        startActivity(new Intent(getApplicationContext(),Resume.class));
                        overridePendingTransition(0,0);
                        finish();
                        return true;

                    case R.id.about:
                        startActivity(new Intent(getApplicationContext(),about.class));
                        overridePendingTransition(0,0);
                        finish();
                        return true;
                }
                return false;
            }
        });

    }
}
