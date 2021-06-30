package com.example.chetancv;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAuth = FirebaseAuth.getInstance();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser!=null)
        {
            Toast.makeText(this, "User already logged in.", Toast.LENGTH_SHORT).show();
            redirect();
        }

    }

    private void redirect() {
        Intent i = new Intent(MainActivity.this,Resume.class);
        startActivity(i);
        finish();
    }


    public void launch(View view) {
        Intent i = new Intent(MainActivity.this, Login.class);
        startActivity(i);
        finish();
    }
}
