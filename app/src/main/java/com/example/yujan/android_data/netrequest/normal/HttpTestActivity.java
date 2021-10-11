package com.example.yujan.android_data.netrequest.normal;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Bundle;
import android.webkit.WebView;
import android.widget.ImageView;

import com.example.yujan.android_data.R;
import com.example.yujan.android_data.sjms.base.BaseActivity;

public class HttpTestActivity extends BaseActivity {
    private WebView mWebView;
    private ImageView mImageView;
    private SendUrlTask mSendUrlTask;
    private SendUrlImgTask mSendUrlImgTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_http_test);
        mWebView = findViewById(R.id.webView);
        mImageView = findViewById(R.id.image);
        //加载网页
        mSendUrlTask = new SendUrlTask("https://www.baidu.com/");
        mSendUrlTask.execute();
        //加载图片
        PermissionUtils.permission(this);
        mSendUrlImgTask = new SendUrlImgTask("https://www.baidu.com/img/bd_logo1.png");
        mSendUrlImgTask.execute();
    }

    private class SendUrlTask extends AsyncTask<Void, Void, String> {
        private String url;

        public SendUrlTask(String url) {
            this.url = url;
        }

        @Override
        protected String doInBackground(Void... voids) {
            return HttpUtils.sendRul(url);
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            mWebView.loadData(s, "text/html;charset=utf-8", null);
        }
    }

    private class SendUrlImgTask extends AsyncTask<Void, Void, Bitmap> {
        private String url;

        public SendUrlImgTask(String url) {
            this.url = url;
        }

        @Override
        protected Bitmap doInBackground(Void... voids) {
            return HttpUtils.loadImage(url);
        }

        @Override
        protected void onPostExecute(Bitmap s) {
            super.onPostExecute(s);
            if (s != null) {
                mImageView.setImageBitmap(s);
            }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mSendUrlTask != null) {
            mSendUrlTask.cancel(true);
        }
        if (mSendUrlImgTask != null) {
            mSendUrlImgTask.cancel(true);
        }
    }
}
