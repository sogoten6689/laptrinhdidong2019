package com.example.tuan5bai3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        WebView webView=(WebView)findViewById(R.id.webview1);
        webView.loadUrl("https://maps.google.com");
        webView.getSettings().setJavaScriptEnabled(true);

    }
}
