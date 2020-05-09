package com.example.yujan.android_data.exception;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Environment;
import android.os.Process;
import android.util.Log;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by yujan on 2020/4/26.
 */

public class CrashHandler implements Thread.UncaughtExceptionHandler {

    private static final String PATH = Environment.getExternalStorageDirectory().getPath() + "/crashlog/";

    private static final String FILE_NAME = "crash";

    private static final String FILE_SUFFIX = ".log";

    private static final String TAG = "CrashHandler";

    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    private static CrashHandler mInstance = new CrashHandler();

    private Context mContext;

    private Thread.UncaughtExceptionHandler mDefaultCrashHandler;

    public static CrashHandler getInstance() {
        return mInstance;
    }

    public void init(Context context) {
        mDefaultCrashHandler = Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(this);
        mContext = context.getApplicationContext();
    }

    /**
     * 关键函数,当程序中有未捕获的异常,系统将自动调用uncaughtException,
     *
     * @param thread    未捕获异常的线程
     * @param throwable throwable为未捕获的异常
     */
    @Override
    public void uncaughtException(Thread thread, Throwable throwable) {
        //把异常信息写到sdcard
        dumpExceptionToSDcard(throwable);
        //上传服务器
        uploadExceptionToServer();
        //打印堆栈
        throwable.printStackTrace();
        //如果系统提供了默认的处理器,交给系统处理,否则kill掉自己
        if (mDefaultCrashHandler != null) {
            mDefaultCrashHandler.uncaughtException(thread, throwable);
        } else {
            Process.killProcess(Process.myPid());
        }
    }

    private void dumpExceptionToSDcard(Throwable throwable) {
        //判断SD卡不存在或无法使用
        if (!Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
            Log.w(TAG, "sdcard unmounted,skip dump exception to sdcard");
            return;
        }
        File dir = new File(PATH);
        if (!dir.exists()) {
            boolean isSuccess = dir.mkdir();
            Log.d(TAG, "isSuccess:" + isSuccess);
        }
        long current = System.currentTimeMillis();
        String time = simpleDateFormat.format(new Date(current));
        File file = new File(PATH + FILE_NAME + time + FILE_SUFFIX);
        Log.d(TAG, "File Path:" + file.getPath());
        try {
            PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter(file)));
            printWriter.println(time);
            dumpDeviceInfo(printWriter);
            throwable.printStackTrace(printWriter);
            printWriter.close();
        } catch (Exception e) {
            Log.e(TAG, "dump exception failed" + e);
        }
    }

    private void dumpDeviceInfo(PrintWriter printWriter) throws PackageManager.NameNotFoundException {
        PackageManager packageManager = mContext.getPackageManager();
        PackageInfo packageInfo = packageManager.getPackageInfo(mContext.getPackageName(), packageManager.GET_ACTIVITIES);
        //print app version
        printWriter.println("App Version: " + packageInfo.versionName + "_" + packageInfo.versionCode);
        //print android version
        printWriter.println("Android OS Version: " + Build.VERSION.RELEASE + "_" + Build.VERSION.SDK_INT);
        //print vender
        printWriter.println("Vender: " + Build.MANUFACTURER);
        //print mode
        printWriter.println("Mode: " + Build.MODEL);
        //print CPU ABI
        printWriter.println("CPU API: " + Build.CPU_ABI);
    }

    private void uploadExceptionToServer() {
        //// TODO: 18/6/9
    }
}
