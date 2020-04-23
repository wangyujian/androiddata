package com.example.yujan.android_data.sjms.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.yujan.android_data.activitymanger.ActivityManger;

/**
 * Created by yujan on 2020/4/10.
 */

public class BaseActivity<T> extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityManger.activity = this;
    }
}
