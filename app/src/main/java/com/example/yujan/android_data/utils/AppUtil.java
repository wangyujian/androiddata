package com.example.yujan.android_data.utils;

import android.app.ActivityManager;
import android.content.Context;

public class AppUtil {
    public static void getMemoryData(Context context) {
        ActivityManager activityManager = (ActivityManager) context.getSystemService(context.ACTIVITY_SERVICE);
        //最大分配内存
        int memory = activityManager.getMemoryClass();
        System.out.println("memory: " + memory);
        //最大分配内存获取方法2
        float maxMemory = (float) (Runtime.getRuntime().maxMemory() * 1.0 / (1024 * 1024));
        //当前分配的总内存
        float totalMemory = (float) (Runtime.getRuntime().totalMemory() * 1.0 / (1024 * 1024));
        //剩余内存
        float freeMemory = (float) (Runtime.getRuntime().freeMemory() * 1.0 / (1024 * 1024));
        System.out.println("maxMemory: " + maxMemory);
        System.out.println("totalMemory: " + totalMemory);
        System.out.println("freeMemory: " + freeMemory);
    }
}
