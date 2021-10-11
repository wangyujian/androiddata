package com.example.yujan.android_data.method;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.yujan.android_data.R;
import com.example.yujan.android_data.sjms.base.BaseActivity;
import com.example.yujan.android_data.utils.DateUtils;

import java.util.List;

public class DateActivity extends BaseActivity implements View.OnClickListener {
    Button btn_get;
    LinearLayout lay_date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date);
        btn_get = findViewById(R.id.btn_get);
        lay_date = findViewById(R.id.lay_date);
        btn_get.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_get:
                lay_date.removeAllViews();
                List<String> list = DateUtils.getPreviousYearMonth(6);
                for (int i = 0; i < list.size(); i++) {
                    TextView textView = new TextView(DateActivity.this);
                    LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                    textView.setLayoutParams(params);
                    textView.setText(list.get(i));
                    lay_date.addView(textView);
                }
                break;
        }
    }
}