package com.example.yujan.android_data.netrequest.okhttppackage1;

import android.os.Handler;
import android.os.Looper;

import com.alibaba.fastjson.JSON;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by yujan on 2020/4/16.
 */

public class OkHttpPackageUtils1 {
    private static OkHttpPackageUtils1 okHttpPackageUtils1;
    private Handler mDelivery;
    private OkHttpClient mOkHttpClient;

    private OkHttpPackageUtils1() {
        mDelivery = new Handler(Looper.getMainLooper());
        //创建OkHttpClient
        mOkHttpClient = new OkHttpClient();
    }

    public static OkHttpPackageUtils1 getInstance() {
        if (okHttpPackageUtils1 == null) {
            synchronized (OkHttpPackageUtils1.class) {
                if (okHttpPackageUtils1 == null) {
                    okHttpPackageUtils1 = new OkHttpPackageUtils1();
                }
            }
        }
        return okHttpPackageUtils1;
    }

    public static void getAsyn(String url, ResultCallback callback) {
        getInstance()._getAsyn(url, callback);
    }

    public void _getAsyn(String url, final ResultCallback callBack) {
        final Request request = new Request.Builder()
                .url(url)
                .build();
        deliveryResult(callBack, request);
    }

    private void deliveryResult(final ResultCallback callback, final Request request) {
        mOkHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                sendFailedStringCallback(request, e, callback);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                try {
                    final String string = response.body().string();
                    if (callback.mType == String.class) {
                        sendSuccessResultCallback(string, callback);
                    } else {
                        Object o = JSON.parseObject(string, callback.mType);
                        sendSuccessResultCallback(o, callback);
                    }
                } catch (IOException e) {
                    sendFailedStringCallback(response.request(), e, callback);
                } catch (com.google.gson.JsonParseException e) {//Json解析的错误
                    sendFailedStringCallback(response.request(), e, callback);
                }
            }
        });
    }

    private void sendFailedStringCallback(final Request request, final Exception e, final ResultCallback callback) {
        mDelivery.post(new Runnable() {
            @Override
            public void run() {
                if (callback != null)
                    callback.onError(request, e);
            }
        });
    }

    private void sendSuccessResultCallback(final Object object, final ResultCallback callback) {
        mDelivery.post(new Runnable() {
            @Override
            public void run() {
                if (callback != null) {
                    callback.onResponse(object);
                }
            }
        });
    }

}
