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

/**
 * 作用：
 * Model_View_Presenter模型演示
 * 详情：
 * MVP跟MVC很相像，文章开头列出了很多种MVC的设计图，所以根据MVC的发展来看，我们把MVP当成MVC来看也不为过，因为MVP也是三层，
 * 唯一的差别是Model和View之间不进行通讯，都是通过Presenter完成,Presenter负责完成View于Model间的交互和业务逻辑。
 * 总结：
 * 实现了视图层的独立，通过中间层Preseter实现了Model和View的完全解耦。MVP彻底解决了MVC中View和Controller傻傻分不清楚的问题，但是随着业务逻辑的增加，
 * 一个页面可能会非常复杂，UI的改变是非常多，会有非常多的case，这样就会造成View的接口会很庞大。
 */
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
        tv_tip.setText("登录转态：\n用户名："
                + userInfoBean.getName()
                + ",用户等级："
                + userInfoBean.getLevel());
    }

    @Override
    public void updateLoginFailView() {
        tv_tip.setText("登录转态：\n登录失败");
    }
}

