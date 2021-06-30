package com.example.chetancv;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Login extends AppCompatActivity {

    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mAuth = FirebaseAuth.getInstance();
    }

    public void next(View view) {
        EditText etmail = findViewById(R.id.Email);
        EditText passwo = findViewById(R.id.etPassword);

        String email = etmail.getText().toString();
        String pass = passwo.getText().toString();

        if(email.isEmpty() || pass.isEmpty())
        {
            Toast.makeText(Login.this,"Email or password cannot be blank.",Toast.LENGTH_LONG ).show();
            return;
        }
        mAuth.signInWithEmailAndPassword(email,pass).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful())
                {
                    Toast.makeText(Login.this,"Login successfull",Toast.LENGTH_LONG ).show();
                    Intent i =  new Intent(Login.this,Resume.class);
                    startActivity(i);
                    finish();
                }
                else
                {
                    Toast.makeText(Login.this,"Login unsuccessfull",Toast.LENGTH_LONG ).show();
                }
            }
        });
    }

    public void sign(View view) {
        Intent i = new Intent(Login.this,SignUp.class);
        startActivity(i);
        finish();
    }
}
