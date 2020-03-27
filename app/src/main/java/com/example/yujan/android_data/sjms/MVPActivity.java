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
import com.example.yujan.android_data.sjms.model.RequestModel;

import java.util.Random;

public class MVPActivity extends AppCompatActivity {
    private EditText edt_input;
    private TextView tv_tip;
    private RequestModel requestModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvp);
        edt_input = findViewById(R.id.edt_input);
        tv_tip = findViewById(R.id.tv_tip);
        requestModel = new RequestModel();
        findViewById(R.id.btn_login).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputInfo = getUserInputInfo();
                if (TextUtils.isEmpty(inputInfo)) {
                    Toast.makeText(MVPActivity.this,
                            "请输入用户名",
                            Toast.LENGTH_SHORT).
                            show();
                } else {
                    requestModel.getUserLoginInfo(inputInfo, new LoginCallBack() {
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
            }
        });
    }

    /**
     * 获取用户输入框信息
     */
    private String getUserInputInfo() {
        return edt_input.getText().toString();
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

