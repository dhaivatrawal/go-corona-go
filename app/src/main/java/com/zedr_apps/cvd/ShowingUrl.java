package com.zedr_apps.cvd;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;

import com.anshulthakur.networkstatechecker.InternetStateChecker;

public class ShowingUrl extends AppCompatActivity {
    InternetStateChecker checker;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showing_url);
        checker = new InternetStateChecker.Builder(this).build();

        WebView webView = (WebView)findViewById(R.id.webview);
        webView.loadUrl("https://www.worldometers.info/coronavirus/countries-where-coronavirus-has-spread/");

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        checker.stop();
    }
}
