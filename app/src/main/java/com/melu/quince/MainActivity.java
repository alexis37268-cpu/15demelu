package com.melu.quince;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends Activity {
    private WebView web;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Barras del sistema del mismo azul noche que el libro
        getWindow().setStatusBarColor(Color.parseColor("#1b1f3a"));
        getWindow().setNavigationBarColor(Color.parseColor("#1b1f3a"));

        web = new WebView(this);
        web.setBackgroundColor(Color.parseColor("#1b1f3a"));
        WebSettings s = web.getSettings();
        s.setJavaScriptEnabled(true);      // pasar páginas, gatitos y coser el 15
        s.setDomStorageEnabled(true);      // recuerda los gatitos encontrados
        s.setAllowFileAccess(true);
        web.setWebViewClient(new WebViewClient());
        setContentView(web);

        if (savedInstanceState != null) {
            web.restoreState(savedInstanceState);
        } else {
            web.loadUrl("file:///android_asset/index.html");
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        web.saveState(outState);
    }
}
