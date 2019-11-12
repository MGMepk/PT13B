package com.manuelgarcia.pt13b;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class NavegadorPropi extends AppCompatActivity {
    WebView myWebView = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        try {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_navegador_propi);

            Intent intent = getIntent();
            Uri url = intent.getData();

            Log.d("test", "rep: " + url.toString());

            myWebView = findViewById(R.id.ourNav);

            myWebView.setWebViewClient(new myWebViewClient());

            myWebView.getSettings().setJavaScriptEnabled(true);

            myWebView.loadUrl(url.toString());

        } catch (Exception e) {
            e.printStackTrace();
            Log.d("test", e.getMessage());
        }
    }

    private class myWebViewClient extends WebViewClient {

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            if (Uri.parse(url).getHost().contains("escoladeltreball")) {

                Log.d("test", "shouldOverride no: " + url);
                return false;
            }

            Log.d("test", "shouldOverride yes: " + url);
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            startActivity(intent);
            return true;
        }

    }
}
