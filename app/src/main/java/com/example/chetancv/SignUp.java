package com.example.chetancv;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignUp extends AppCompatActivity {

    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        mAuth = FirebaseAuth.getInstance();
    }

    public void log(View view) {
        Intent i = new Intent(SignUp.this,Login.class);
        startActivity(i);
        finish();
    }

    public void sign_up(View view) {
        EditText sign_up_email = findViewById(R.id.sign_up_email);
        EditText sign_up_password = findViewById(R.id.sign_up_password);
        EditText confirm_password = findViewById(R.id.confirm_password);

        String email = sign_up_email.getText().toString();
        String password = sign_up_password.getText().toString();
        String confirmpass = confirm_password.getText().toString();

        if(email.isEmpty() || password.isEmpty() || confirmpass.isEmpty())
        {
            Toast.makeText(SignUp.this,"Email or password can't be blank.",Toast.LENGTH_LONG).show();
            return;
        }

        if (!password.equals(confirmpass))
        {
            Toast.makeText(SignUp.this,"Password and confirm password does't match.",Toast.LENGTH_LONG).show();
            return;
        }

        if (password.length()>=1 && password.length()<6)
        {
            Toast.makeText(SignUp.this,"Password connot be less then 6 characters.",Toast.LENGTH_LONG).show();
            return;
        }

        mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful())
                {
                    Toast.makeText(SignUp.this,"Account created.",Toast.LENGTH_LONG).show();
                    Intent i = new Intent(SignUp.this,Resume.class);
                    startActivity(i);
                    finish();
                }
                else
                {
                    Toast.makeText(SignUp.this,"Error creating account.",Toast.LENGTH_LONG).show();
                }
            }
        });



    }
}
