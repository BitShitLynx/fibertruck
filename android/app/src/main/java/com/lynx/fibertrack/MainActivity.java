package com.lynx.fibertrack;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.getcapacitor.BridgeActivity;

public class MainActivity extends BridgeActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        WebView webView = getBridge().getWebView();
        WebSettings settings = webView.getSettings();
        settings.setCacheMode(WebSettings.LOAD_NO_CACHE);
        webView.clearCache(true);
        webView.clearHistory();
        webView.clearFormData();
        // Desregistrar service workers viejos via JavaScript
        webView.evaluateJavascript(
            "if('serviceWorker' in navigator){" +
            "  navigator.serviceWorker.getRegistrations().then(function(regs){" +
            "    regs.forEach(function(r){ r.unregister(); });" +
            "  });" +
            "  caches.keys().then(function(keys){" +
            "    keys.forEach(function(k){ caches.delete(k); });" +
            "  });" +
            "}",
            null
        );
    }

    @Override
    public void onResume() {
        super.onResume();
        getBridge().getWebView().clearCache(true);
    }
}
