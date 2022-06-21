package com.zedr_apps.cvd;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;

import com.anshulthakur.networkstatechecker.InternetStateChecker;

public class Protection extends AppCompatActivity {
    InternetStateChecker checker;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_protection);
        checker = new InternetStateChecker.Builder(this).build();

        WebView webView = (WebView)findViewById(R.id.webview);
        webView.loadUrl("https://www.cdc.gov/coronavirus/2019-ncov/prevent-getting-sick/prevention.html");

    }
}
