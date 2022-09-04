package com.example.yujan.android_data.base;

import android.app.Application;
import android.content.Context;

import com.example.yujan.android_data.exception.CrashHandler;


/**
 * Created by yujan on 2020/4/23.
 */

public class MyApplication extends Application {
    public static Context context;
    public void onCreate() {
        super.onCreate();
        context=this;
        initMethod();
    }

    private void initMethod() {
        ApplicationManger.getInstance(this).initMethod();
    }
}
