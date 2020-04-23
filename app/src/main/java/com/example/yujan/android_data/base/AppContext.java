package com.example.yujan.android_data.base;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Application;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.MainThread;
import android.util.Log;
import android.widget.Toast;

import com.example.yujan.android_data.MainActivity;
import com.example.yujan.android_data.activitymanger.ActivityManger;


/**
 * Created by yujan on 2020/4/23.
 */

public class AppContext extends Application {
    protected static AppContext instance;
    private Handler handler;

    public void onCreate() {
        super.onCreate();
        instance = this;
            handler = new Handler(Looper.getMainLooper());
            Thread.setDefaultUncaughtExceptionHandler(restartHandler); // 程序崩溃时触发线程  以下用来捕获程序崩溃异常
    }

    // 创建服务用于捕获崩溃异常
    private Thread.UncaughtExceptionHandler restartHandler = new Thread.UncaughtExceptionHandler() {
        public void uncaughtException(final Thread thread, Throwable ex) {
            handler.post(new Runnable() {
                @Override
                public void run() {
                    new AlertDialog.Builder(ActivityManger.activity)
                            .setMessage("程序发生异常，重启应用")
                            .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    restartApp();//发生崩溃异常时,重启应用
                                    Log.i("ceshi:", thread.getName());
                                }
                            }).create().show();
                }
            });
        }
    };

    public void restartApp() {
        Intent intent = new Intent(instance, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        instance.startActivity(intent);
        android.os.Process.killProcess(android.os.Process.myPid());  //结束进程之前可以把你程序的注销或者退出代码放在这段代码之前
    }

}
