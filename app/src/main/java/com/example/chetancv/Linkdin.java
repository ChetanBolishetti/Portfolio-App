package com.example.chetancv;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Linkdin extends AppCompatActivity {

    DatabaseReference myref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linkdin);

        ProgressBar lkpb = findViewById(R.id.lkpb);
        lkpb.setVisibility(View.VISIBLE);
        myref = FirebaseDatabase.getInstance().getReference().child("Data");
        WebView wv = findViewById(R.id.webview);
        myref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String lkd = snapshot.child("linkedin").getValue().toString();
                wv.loadUrl(lkd);
                wv.getSettings().setJavaScriptEnabled(true);
                wv.setWebViewClient(new WebViewClient());
                lkpb.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    public void bac(View view) {
        Intent i = new Intent(Linkdin.this, Resume.class);
        startActivity(i);
    }
}
