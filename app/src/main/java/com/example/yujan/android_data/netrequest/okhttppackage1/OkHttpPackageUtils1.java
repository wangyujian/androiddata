package com.example.yujan.android_data.netrequest.okhttppackage1;

import android.os.Handler;
import android.os.Looper;

import com.alibaba.fastjson.JSON;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by yujan on 2020/4/16.
 */

public class OkHttpPackageUtils1 {
    private Handler handler;
    private OkHttpClient okHttpClient;

    private OkHttpPackageUtils1() {
        handler = new Handler(Looper.getMainLooper());
        //创建OkHttpClient
        okHttpClient = new OkHttpClient();
    }

    public void sendGetRequestPackage1(String url, final OkHttpPackage1ResponseCallBack callBack) {
        //创建一个Request
        final Request request = new Request
                .Builder()
                .url(url)
                .build();
        //创建Call回调
        Call call = okHttpClient.newCall(request);
        //请求加入回调
        call.enqueue(new Callback() {
            @Override
            public void onFailure(final Call call, IOException e) {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        if (callBack != null) {
//                            callBack.onfailed(request, e);
                        }
                    }
                });
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String s1 = response.body().toString();

            }
        });
    }

    private void onResponFailedResult(final Call call, IOException e) {

    }
}
