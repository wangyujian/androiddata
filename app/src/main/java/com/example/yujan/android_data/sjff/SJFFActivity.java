package com.example.yujan.android_data.sjff;

import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import com.example.yujan.android_data.R;

import androidx.appcompat.app.AppCompatActivity;

/**
 * 事件分发
 * 核心思想：
 * 1）用户触摸屏幕会产生一系列的事件，比如点击，移动，抬起等；
 * 2）事件会在activity,viewGroup,view间传递；
 * 3）开发者可以根据情况控制事件的传递；
 * 4）事件最终会被某个view消费；
 */
public class SJFFActivity extends AppCompatActivity implements View.OnClickListener, View.OnTouchListener {
    public static final String TAG = "事件分发";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sjffactivity);
        findViewById(R.id.btn).setOnClickListener(this);
        findViewById(R.id.btn).setOnTouchListener(this);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.d(TAG, "SJFFActivity:dispatchTouchEvent 点击");
                break;
            case MotionEvent.ACTION_MOVE:
                Log.d(TAG, "SJFFActivity:dispatchTouchEvent 移动");
                break;
            case MotionEvent.ACTION_UP:
                Log.d(TAG, "SJFFActivity:dispatchTouchEvent 抬起");
                break;
        }
        return true;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.d(TAG, "SJFFActivity：onTouchEvent");
        return super.onTouchEvent(event);
    }

    @Override
    public void onClick(View v) {
        Log.d(TAG, "SJFFActivity：onClick");
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        Log.d(TAG, "SJFFActivity：onTouch");
        return false;
    }
}