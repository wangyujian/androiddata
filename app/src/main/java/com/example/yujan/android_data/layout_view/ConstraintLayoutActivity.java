package com.example.yujan.android_data.layout_view;

import android.graphics.drawable.TransitionDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.yujan.android_data.R;
import com.example.yujan.android_data.base.MyApplication;
import com.example.yujan.android_data.utils.AppUtil;
import com.example.yujan.android_data.utils.ImageUtil;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class ConstraintLayoutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_constraint_layout);
//        setPaint();
        AppUtil.getMemoryData(this);
        new Thread(new Runnable() {
            @Override
            public void run() {
                handler.sendEmptyMessage(0);
            }
        }).start();
    }

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            setBitMap();
        }
    };

    public void sendMessage(View view) {
        Toast.makeText(ConstraintLayoutActivity.this, "ConstraintLayoutActivity", Toast.LENGTH_LONG).show();
        AppUtil.getMemoryData(this);
    }

    public void setImageTransition() {
        TransitionDrawable transitionDrawable = (TransitionDrawable) MyApplication.context.getResources().getDrawable(R.drawable.transition);
        ImageView iv_logo = findViewById(R.id.iv_logo);
        iv_logo.setImageDrawable(transitionDrawable);
        iv_logo.setContentDescription("0000i00");
        transitionDrawable.setCrossFadeEnabled(true);
        transitionDrawable.startTransition(1000);
    }

    public void setPaint() {
        View view = findViewById(R.id.view_paint);
        view.setBackground(new MyDraw());
    }

    public void setBitMap() {
        LinearLayout lay_bitmap = findViewById(R.id.lay_bitmap);
        for (int i = 0; i < 15; i++) {
            ImageView imageView = new ImageView(this);
//            imageView.setImageResource(R.drawable.iv_large_banner);
            imageView.setImageBitmap(ImageUtil.decodeSampledBitmapFromResource(getResources(), R.drawable.iv_large_banner, getResources().getDisplayMetrics().widthPixels, 100));
//            imageView.setLayoutParams(new LinearLayout.LayoutParams(100, 100));
//            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            lay_bitmap.addView(imageView);
        }
    }
}