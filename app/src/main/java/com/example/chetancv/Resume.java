package com.example.chetancv;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;


public class Resume extends AppCompatActivity {

    DatabaseReference myref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resume);


        ProgressBar p = findViewById(R.id.pg);
        p.setVisibility(View.VISIBLE);
        TextView name,qua;
        name = findViewById(R.id.name);
        qua = findViewById(R.id.Qua);
        ImageView ig = findViewById(R.id.chetanimg);
        myref = FirebaseDatabase.getInstance().getReference().child("Data");
        myref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String iname = snapshot.child("name").getValue().toString().toUpperCase();
                String bc = snapshot.child("qualification").getValue().toString();
                String img = snapshot.child("image").getValue().toString();

                name.setText(iname);
                qua.setText(bc);
                Picasso.get().load(img).into(ig);
                p.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });


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




    public void link(View view) {
        Intent i = new Intent(Resume.this, Linkdin.class);
        startActivity(i);
        finish();
    }


    public void popup(View view) {
        Intent i = new Intent(Resume.this, pop_up_window.class);
        startActivity(i);
    }

    public void rload(View view) {
        Intent i = new Intent(Resume.this,resumeimg.class);
        startActivity(i);
    }
}
