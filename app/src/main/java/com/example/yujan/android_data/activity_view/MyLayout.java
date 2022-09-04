package com.example.yujan.android_data.activity_view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;

public class MyLayout extends LinearLayout {
    public MyLayout(Context context) {
        super(context);
    }

    public MyLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MyLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.d(SJFFActivity.TAG, "MyLayout:dispatchTouchEvent");
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        Log.d(SJFFActivity.TAG, "MyLayout:dispatchTouchEvent");
        return super.onInterceptTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.d(SJFFActivity.TAG, "MyLayout：onTouchEvent");
        return super.onTouchEvent(event);
    }
}
