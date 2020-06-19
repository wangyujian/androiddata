package com.example.yujan.android_data.webview;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.example.yujan.android_data.R;
import com.example.yujan.android_data.sjms.base.BaseActivity;

public class WebViewActivity extends BaseActivity {
    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
        webView = findViewById(R.id.webView);
        webView.loadUrl("https://mobile.xingzb.cn/share/#/apphtmlview?id=1725&type=0");
        WebSettings webSettings = webView.getSettings();
        //如果访问的页面中要与Javascript交互，则webview必须设置支持Javascript
        webSettings.setJavaScriptEnabled(true);
        //设置自适应屏幕，两者合用
//        webSettings.setUseWideViewPort(true); //将图片调整到适合webview的大小
//        webSettings.setLoadWithOverviewMode(true); // 缩放至屏幕的大小

//        webSettings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN); //支持内容重新布局

    }
}
