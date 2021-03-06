package com.example.chetancv;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.bumptech.glide.Glide;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

public class CV extends AppCompatActivity {

    DatabaseReference myref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c_v);

        ProgressBar cvpb = findViewById(R.id.cpb);
        cvpb.setVisibility(View.VISIBLE);
        ImageView cv = findViewById(R.id.cvimg);

        myref = FirebaseDatabase.getInstance().getReference().child("Data");
        myref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String cvlink = snapshot.child("resume").getValue().toString();
                Glide.with(CV.this).load(cvlink).into(cv);
                cvpb.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }

    public void back(View view) {
        Intent i = new Intent(CV.this, Resume.class);
        startActivity(i);
    }
}
