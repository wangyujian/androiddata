package com.example.yujan.android_data.netrequest.okhttppackage1;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.yujan.android_data.R;
import com.example.yujan.android_data.netrequest.bean.BannerVo;
import com.example.yujan.android_data.netrequest.bean.RequestBody;
import com.example.yujan.android_data.sjms.base.BaseActivity;

import okhttp3.Request;

/**
 * OkHttp的初步封装
 */
public class OkhttpPackage1Activity extends BaseActivity implements View.OnClickListener {
    private TextView tv_tip;
    private TextView tv_login_result;
    private EditText edt_name;
    private EditText edt_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_okhttp_package1);
        tv_tip = findViewById(R.id.tv_tip);
        tv_login_result = findViewById(R.id.tv_login_result);
        edt_name = findViewById(R.id.edt_input_username);
        edt_password = findViewById(R.id.edt_input_password);
        findViewById(R.id.btn_get).setOnClickListener(this);
        findViewById(R.id.btn_login).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            //Okhttp之Get请求
            case R.id.btn_get:
                OkHttpPackageUtils1.getAsyn("https://www.wanandroid.com/banner/json", new ResultCallback<RequestBody<BannerVo>>() {
                    @Override
                    public void onError(Request request, Exception e) {
                        Toast.makeText(OkhttpPackage1Activity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onResponse(RequestBody<BannerVo> response) {
                        if (response != null && response.getData() != null && response.getData().size() > 0) {
                            Toast.makeText(OkhttpPackage1Activity.this, response.getData().get(0).getDesc(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                break;
            case R.id.btn_login:

                break;
        }
    }

}
