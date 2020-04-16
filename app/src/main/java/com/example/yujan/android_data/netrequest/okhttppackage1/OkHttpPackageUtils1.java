package com.example.yujan.android_data.netrequest.okhttppackage1;

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

    public static void sendGetRequestPackage1(String url) {
        //创建OkHttpClient
        OkHttpClient okHttpClient = new OkHttpClient();
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
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String s1 = response.body().toString();

            }
        });
    }

    public static void sendPostRequestPackage1(String url) {
    }
}
