package com.example.yujan.android_data.sjms.base;

import android.os.Bundle;

import com.example.yujan.android_data.activitymanger.ActivityUtils;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


/**
 * Created by yujan on 2020/4/10.
 */

public class BaseActivity<T> extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityUtils.activity = this;
    }
}
