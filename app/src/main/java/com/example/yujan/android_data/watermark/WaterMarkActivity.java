package com.example.yujan.android_data.watermark;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.yujan.android_data.R;
import com.example.yujan.android_data.sjms.base.BaseActivity;

public class WaterMarkActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_water_mark);
//        Watermark.getInstance().show(this, "xingzhibao");
        // 可以自定义水印文字颜色、大小和旋转角度
        Watermark.getInstance()
                .setText("Fantasy BlogDemo")
                .setTextColor(0xAE000000)
                .setTextSize(16)
                .setRotation(-30)
                .show(this);
        findViewById(R.id.iv_pic).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(WaterMarkActivity.this, "点击了", Toast.LENGTH_LONG).show();
            }
        });
        findViewById(R.id.lay_type).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(WaterMarkActivity.this, "lay_type点击了", Toast.LENGTH_LONG).show();
            }
        });
    }
}
