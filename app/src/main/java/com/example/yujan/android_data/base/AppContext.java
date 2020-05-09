package com.example.yujan.android_data.base;

import android.app.Application;

import com.example.yujan.android_data.exception.CrashHandler;


/**
 * Created by yujan on 2020/4/23.
 */

public class AppContext extends Application {

    public void onCreate() {
        super.onCreate();
//        ApplicationManger.getInstance(this).initException();
        CrashHandler.getInstance().init(this);
    }

}
