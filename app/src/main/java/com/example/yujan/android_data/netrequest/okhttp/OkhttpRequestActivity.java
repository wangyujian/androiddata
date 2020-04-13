package com.example.yujan.android_data.netrequest.okhttp;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.yujan.android_data.R;
import com.example.yujan.android_data.sjms.base.BaseActivity;

/**
 * 1）Okhttp之Get请求
 * 需求：获取首页banner（https://www.wanandroid.com/banner/json）的数据
 * 通过开启子线程获取到数据后，到主线程中更新UI
 */
public class OkhttpRequestActivity extends BaseActivity implements View.OnClickListener {
    private TextView tv_tip;
    private TextView tv_login_result;
    private EditText edt_name;
    private EditText edt_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_okhttp_request);
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
                //开启子线程
                new Thread() {
                    @Override
                    public void run() {
                        OkHttpUtils.okhttpGetRequestMethod("https://www.wanandroid.com/banner/json",
                                new OkhttpResponCallBack() {
                                    @Override
                                    public void onSuccess(String content) {
                                        Message message = new Message();
                                        message.what = 1001;
                                        message.obj = content;
                                        mHandle.sendMessage(message);
                                        Log.i("currentThread():onClick", Thread.currentThread().getName());
                                    }

                                    @Override
                                    public void onFailed() {

                                    }
                                });
                    }
                }.start();
                break;
            case R.id.btn_login:
                final String name = edt_name.getText().toString();
                final String password = edt_password.getText().toString();
                if (TextUtils.isEmpty(name) || TextUtils.isEmpty(password)) {
                    Toast.makeText(OkhttpRequestActivity.this, "请输入用户名/密码", Toast.LENGTH_SHORT).show();
                    return;
                }
                new Thread() {
                    @Override
                    public void run() {
                        OkHttpUtils.okhttpPostRequestMethod("https://www.wanandroid.com/user/login?username=" + name + "&password=" + password,
                                "",
                                new OkhttpResponCallBack() {
                                    @Override
                                    public void onSuccess(String content) {
                                        Message message = new Message();
                                        message.what = 1002;
                                        message.obj = content;
                                        mHandle.sendMessage(message);
                                    }

                                    @Override
                                    public void onFailed() {

                                    }
                                });
                    }
                }.start();
                break;
        }
    }

    //在主线程中更新UI
    private Handler mHandle = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 1001:
                    tv_tip.setText("返回值：" + (String) msg.obj);
                    Log.i("currentThread():mHandle", Thread.currentThread().getName());
                    break;
                case 1002:
                    tv_login_result.setText("返回值：" + (String) msg.obj);
                    break;
            }
        }
    };

}
