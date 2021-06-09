package com.example.chetancv;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class Linkdin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linkdin);

        WebView wv = findViewById(R.id.webview);
        wv.loadUrl("https://www.linkedin.com/in/chetan-bolishetti-237653208");
        wv.getSettings().setJavaScriptEnabled(true);
        wv.setWebViewClient(new WebViewClient());
    }

    public void bac(View view) {
        Intent i = new Intent(Linkdin.this, Resume.class);
        startActivity(i);
    }
}
