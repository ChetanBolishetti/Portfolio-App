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

public class about extends AppCompatActivity {

    DatabaseReference myref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        ProgressBar apb = findViewById(R.id.apb);
        apb.setVisibility(View.VISIBLE);
        BottomNavigationView bv = findViewById(R.id.bottom_nav);
        bv.setSelectedItemId(R.id.about);
        TextView pname,pqua,pnum,pclg,pemail;
        pname = findViewById(R.id.pname);
        pqua = findViewById(R.id.pqua);
        pnum = findViewById(R.id.pnum);
        pemail = findViewById(R.id.pemail);
        pclg = findViewById(R.id.pclg);

        myref = FirebaseDatabase.getInstance().getReference().child("Data");
        myref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String aname = snapshot.child("name").getValue().toString();
                String aemail = snapshot.child("email").getValue().toString();
                String aqua = snapshot.child("qualification").getValue().toString();
                String anum = snapshot.child("number").getValue().toString();
                String aclg = snapshot.child("college").getValue().toString();

                pname.setText("Name : "+aname);
                pemail.setText("Email : "+aemail);
                pnum.setText("Mobile : "+anum);
                pqua.setText("Qualification : "+aqua);
                pclg.setText("College : "+aclg);
                apb.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(about.this,"Could't load data",Toast.LENGTH_LONG).show();

            }
        });
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
