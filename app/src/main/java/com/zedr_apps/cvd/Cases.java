package com.zedr_apps.cvd;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;

import com.anshulthakur.networkstatechecker.InternetStateChecker;

public class Cases extends AppCompatActivity {
    InternetStateChecker checker;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cases);
        checker = new InternetStateChecker.Builder(this).build();


        WebView webView = (WebView)findViewById(R.id.webview);
        webView.loadUrl("https://www.worldometers.info/coronavirus/coronavirus-cases/");

    }
}
