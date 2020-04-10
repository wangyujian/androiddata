package com.example.yujan.android_data.netrequest.okhttp;

import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by yujan on 2020/4/9.
 */

public class OkHttpUtils {
    public static final MediaType JSON = MediaType.get("application/json; charset=utf-8");

    /**
     * okHttp之GET请求
     *
     * @param url
     * @param callBack
     */
    public static void okhttpGetRequestMethod(String url, OkhttpResponCallBack callBack) {
        try {
            OkHttpClient client = new OkHttpClient();

            Request request = new Request.Builder()
                    .url(url)
                    .build();

            Response response = client.newCall(request).execute();
            if (response != null) {
                String result = response.body().string();
                callBack.onSuccess(result);
            } else {
                callBack.onFailed();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * okHttp之POST请求
     *
     * @param url
     * @param json
     * @param callBack
     */
    public static void okhttpPostRequestMethod(String url, String json, OkhttpResponCallBack callBack) {
        try {
            OkHttpClient client = new OkHttpClient();
            RequestBody body = RequestBody.create(json, JSON);
            Request request = new Request.Builder()
                    .url(url)
                    .post(body)
                    .build();

            Response response = client.newCall(request).execute();
            if (response != null) {
                String result = response.body().string();
                callBack.onSuccess(result);
            } else {
                callBack.onFailed();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
