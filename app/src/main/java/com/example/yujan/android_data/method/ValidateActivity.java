package com.example.yujan.android_data.method;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.yujan.android_data.R;
import com.example.yujan.android_data.sjms.base.BaseActivity;
import com.example.yujan.android_data.utils.ValidateUtil;

public class ValidateActivity extends BaseActivity implements View.OnClickListener {
    EditText edt_tel, edt_mail,edt_idCard;
    Button btn_check_tel, btn_check_mail,btn_check_idCard;
    TextView tv_result_tel, tv_result_mail,tv_result_idCard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_validate);
        btn_check_tel = findViewById(R.id.btn_check_tel);
        btn_check_mail = findViewById(R.id.btn_check_mail);
        btn_check_idCard = findViewById(R.id.btn_check_idCard);
        edt_tel = findViewById(R.id.edt_tel);
        edt_mail = findViewById(R.id.edt_mail);
        edt_idCard = findViewById(R.id.edt_idCard);
        tv_result_tel = findViewById(R.id.tv_result_tel);
        tv_result_mail = findViewById(R.id.tv_result_mail);
        tv_result_idCard = findViewById(R.id.tv_result_idCard);
        btn_check_tel.setOnClickListener(this);
        btn_check_mail.setOnClickListener(this);
        btn_check_idCard.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            //效验手机号
            case R.id.btn_check_tel:
                tv_result_tel.setText("结果：" + ValidateUtil.isMobileNO(edt_tel.getText().toString()));
                break;
            //效验邮箱
            case R.id.btn_check_mail:
                tv_result_mail.setText("结果：" + ValidateUtil.isMail(edt_mail.getText().toString()));
                break;
            //效验身份证号
            case R.id.btn_check_idCard:
                tv_result_idCard.setText("结果：" + ValidateUtil.isIdCard(edt_idCard.getText().toString()));
                break;
        }
    }
}