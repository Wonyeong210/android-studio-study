# 05 WebView

1. activity_main.xml 에 WebView 태그 추가

```xml
<WebView
        android:id="@+id/webView"
        android:layout_width="match_parent"
        android:layout_height="match_parent"></WebView>
```

2. MainActivity.java에 WebView 연결 + onKeyDown 메소드, WebViewClientClass 메소드 추가

```java
package com.example.webviewexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {

    private WebView webView;
    private String url = "https://www.naver.com";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        webView = (WebView)findViewById(R.id.webView);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl(url);
        webView.setWebChromeClient(new WebChromeClient());
        webView.setWebViewClient(new WebViewClientClass());

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        // 특정 안드로이드 키를 입력하면 이걸 지정해줘라

        if((keyCode == KeyEvent.KEYCODE_BACK) && webView.canGoBack()) {
            webView.goBack();
            return true;
        }

        return super.onKeyDown(keyCode, event);
    }

    private class WebViewClientClass extends WebViewClient {
        // 현재 페이지에 url를 읽어올수있는 메소드. 새 창을 읽어올 수 있고 특수한 기능을 만들 수도 있음

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }
}
```

3. app - manifests-AndroidManifest.xml 수정

- manifest 태그 안에 `<uses-permission android:name="android.permission.INTERNET"/>` 추가
- application 태그 안에 `android:usesCleartextTraffic="true"` 추가

4. 결과

[!Untitled](./Untitled.png)
