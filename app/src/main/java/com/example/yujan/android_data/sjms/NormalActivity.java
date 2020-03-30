package com.example.yujan.android_data.sjms;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.yujan.android_data.R;
import com.example.yujan.android_data.sjms.bean.UserInfoBean;
import com.example.yujan.android_data.sjms.callback.LoginCallBack;

import java.util.Random;

public class NormalActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText edt_input;
    private TextView tv_tip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_normal);
        edt_input = findViewById(R.id.edt_input);
        tv_tip = findViewById(R.id.tv_tip);
        findViewById(R.id.btn_login).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_login:
                String inputInfo = getUserInputInfo();
                if (TextUtils.isEmpty(inputInfo)) {
                    Toast.makeText(NormalActivity.this,
                            "请输入用户名",
                            Toast.LENGTH_SHORT).
                            show();
                } else {
                    getUserLoginInfo(inputInfo, new LoginCallBack() {
                        @Override
                        public void onSuccess(UserInfoBean bean) {
                            updateLoginSuccessView(bean);
                        }

                        @Override
                        public void onFailed() {
                            updateLoginFailView();
                        }
                    });
                }
                break;
        }
    }

    /**
     * 获取用户输入框信息
     */
    private String getUserInputInfo() {
        return edt_input.getText().toString();
    }

    /**
     * 获取用户登录信息（模拟）
     *
     * @param userName
     * @param callBack
     */
    private void getUserLoginInfo(String userName, LoginCallBack callBack) {
        Random random = new Random();
        boolean bool = random.nextBoolean();
        if (bool) {
            callBack.onSuccess(new UserInfoBean(userName, 2));
        } else {
            callBack.onFailed();
        }
    }

    /**
     * 登录成功后更新登录状态信息
     *
     * @param userInfoBean
     */
    private void updateLoginSuccessView(UserInfoBean userInfoBean) {
        tv_tip.setText("登录转态：用户名："
                + userInfoBean.getName()
                + ",用户等级："
                + userInfoBean.getLevel());
    }

    /**
     * 登录失败后更新登录状态信息
     */
    private void updateLoginFailView() {
        tv_tip.setText("登录转态：登录失败");
    }
}
