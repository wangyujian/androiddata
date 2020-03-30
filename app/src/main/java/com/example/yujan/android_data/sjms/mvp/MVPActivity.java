package com.example.yujan.android_data.sjms.mvp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.yujan.android_data.R;
import com.example.yujan.android_data.sjms.bean.UserInfoBean;

public class MVPActivity extends AppCompatActivity implements View.OnClickListener, IMVPView {
    private EditText edt_input;
    private TextView tv_tip;
    private IMVPPresenter imvpPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvp);
        edt_input = findViewById(R.id.edt_input);
        tv_tip = findViewById(R.id.tv_tip);
        imvpPresenter = new IMVPPresenter(this);
        findViewById(R.id.btn_login).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_login:
                imvpPresenter.getData(getUserInputInfo());
                break;
        }
    }

    @Override
    public String getUserInputInfo() {
        String inputStr = edt_input.getText().toString();
        if (TextUtils.isEmpty(inputStr)) {
            Toast.makeText(MVPActivity.this,
                    "请输入用户名",
                    Toast.LENGTH_SHORT).
                    show();
        }
        return inputStr;
    }

    @Override
    public void updateLoginSuccessView(UserInfoBean userInfoBean) {
        tv_tip.setText("登录转态：用户名："
                + userInfoBean.getName()
                + ",用户等级："
                + userInfoBean.getLevel());
    }

    @Override
    public void updateLoginFailView() {
        tv_tip.setText("登录转态：登录失败");
    }
}

