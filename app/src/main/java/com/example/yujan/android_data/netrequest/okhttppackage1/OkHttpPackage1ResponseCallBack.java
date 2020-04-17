package com.example.yujan.android_data.netrequest.okhttppackage1;

import java.io.IOException;

import okhttp3.Request;

/**
 * Created by yujan on 2020/4/17.
 */

public interface OkHttpPackage1ResponseCallBack {

    void onfailed(Request request, IOException e);

    void onSuccess(Object o);
}
