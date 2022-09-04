package com.example.yujan.android_data.base;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;

import com.example.yujan.android_data.MainActivity;
import com.example.yujan.android_data.activitymanger.ActivityUtils;
import com.example.yujan.android_data.exception.CrashHandler;
import com.qiyukf.nimlib.sdk.StatusBarNotificationConfig;
import com.qiyukf.unicorn.api.ImageLoaderListener;
import com.qiyukf.unicorn.api.Unicorn;
import com.qiyukf.unicorn.api.UnicornImageLoader;
import com.qiyukf.unicorn.api.YSFOptions;
import com.tencent.rtmp.TXLiveBase;

import androidx.annotation.Nullable;

/**
 * Created by yujan on 2020/4/26.
 */

public class ApplicationManger implements ApplicationIml {
    private static ApplicationManger applicationManger;
    private Handler handler;
    private Context context;

    private ApplicationManger(Context _context) {
        this.context = _context;
    }

    public static ApplicationManger getInstance(Context context) {
        if (applicationManger == null) {
            synchronized (ApplicationManger.class) {
                if (applicationManger == null) {
                    applicationManger = new ApplicationManger(context);
                }
            }
        }
        return applicationManger;
    }

    public void initMethod() {
        CrashHandler.getInstance().init(context);
        initTencentLive();
        initQiYuKF();
    }

    @Override
    public void initException() {
        handler = new Handler(Looper.getMainLooper());
        // 程序崩溃时触发线程以下用来捕获程序崩溃异常
        Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            public void uncaughtException(final Thread thread, Throwable ex) {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        new AlertDialog.Builder(ActivityUtils.activity)
                                .setMessage("程序发生异常，重启应用")
                                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        restartApp();
                                    }
                                }).create().show();
                    }
                });
            }
        });
    }

    public void restartApp() {
        Intent intent = new Intent(context, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
        //结束进程之前可以把你程序的注销或者退出代码放在这段代码之前
        android.os.Process.killProcess(android.os.Process.myPid());
    }

    @Override
    public void initTencentLive() {
        String licenceURL = ""; // 获取到的 licence url
        String licenceKey = ""; // 获取到的 licence key
        TXLiveBase.getInstance().setLicence(context, licenceURL, licenceKey);
    }

    @Override
    public void initQiYuKF() {
        // appKey 可以在七鱼管理系统->设置->App 接入 页面找到
        Unicorn.init(context, "3bc23e5ff3b354d482388601c7f30b1e", options(), new UnicornImageLoader() {
            @Nullable
            @Override
            public Bitmap loadImageSync(String s, int i, int i1) {
                return null;
            }

            @Override
            public void loadImage(String s, int i, int i1, ImageLoaderListener imageLoaderListener) {

            }
        });
    }

    // 如果返回值为null，则全部使用默认参数。
    private YSFOptions options() {
        YSFOptions options = new YSFOptions();
        options.statusBarNotificationConfig = new StatusBarNotificationConfig();
        return options;
    }
}
