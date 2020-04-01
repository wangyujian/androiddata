package com.example.yujan.android_data.sjms.mvc;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.yujan.android_data.R;
import com.example.yujan.android_data.sjms.bean.UserInfoBean;
import com.example.yujan.android_data.sjms.callback.LoginCallBack;

/**
 * 作用：
 * 演示Model_View_Controller模型
 * 详情：
 * 视图层(View)
 * 对应于xml布局文件和java代码动态view部分
 * 控制层(Controller)
 * MVC中Android的控制层是由Activity来承担的，Activity本来主要是作为初始化页面，展示数据的操作，但是因为XML视图功能太弱，
 * 所以Activity既要负责视图的显示又要加入控制逻辑，承担的功能过多。
 * 模型层(Model)
 * 针对业务模型，建立的数据结构和相关的类，它主要负责网络请求，数据库处理，I/O的操作。
 * 总结：
 * 具有一定的分层，model彻底解耦，controller和view并没有解耦
 * 层与层之间的交互尽量使用回调或者去使用消息机制去完成，尽量避免直接持有
 * controller和view在android中无法做到彻底分离，但在代码逻辑层面一定要分清
 * 业务逻辑被放置在model层，能够更好的复用和修改增加业务
 */
public class MVCActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText edt_input;
    private TextView tv_tip;
    private IMVCModel requestModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvc);
        edt_input = findViewById(R.id.edt_input);
        tv_tip = findViewById(R.id.tv_tip);
        requestModel = new IMVCModel();
        findViewById(R.id.btn_login).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_login:
                String inputInfo = getUserInputInfo();
                if (TextUtils.isEmpty(inputInfo)) {
                    Toast.makeText(MVCActivity.this,
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
     * 登录成功后更新登录状态信息
     *
     * @param userInfoBean
     */
    private void updateLoginSuccessView(UserInfoBean userInfoBean) {
        tv_tip.setText("登录转态：\n用户名："
                + userInfoBean.getName()
                + ",用户等级："
                + userInfoBean.getLevel());
    }

    /**
     * 登录失败后更新登录状态信息
     */
    private void updateLoginFailView() {
        tv_tip.setText("登录转态：\n登录失败");
    }
}
