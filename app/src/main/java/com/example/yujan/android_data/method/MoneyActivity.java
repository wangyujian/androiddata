package com.example.yujan.android_data.method;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.yujan.android_data.R;
import com.example.yujan.android_data.sjms.base.BaseActivity;
import com.example.yujan.android_data.utils.MathUtil;

public class MoneyActivity extends BaseActivity implements View.OnClickListener {
    EditText edt_01, edt_02;
    TextView tv_result;
    Button btn_check;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_money);
        edt_01 = findViewById(R.id.edt_01);
        edt_02 = findViewById(R.id.edt_02);
        tv_result = findViewById(R.id.tv_result);
        btn_check = findViewById(R.id.btn_check);
        btn_check.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_check:
                int type = MathUtil.doubleCompare(edt_01.getText().toString(), edt_02.getText().toString());
                switch (type) {
                    case -1:
                        tv_result.setText("结果：" + edt_01.getText().toString() + "小于" + edt_02.getText().toString());
                        break;
                    case 0:
                        tv_result.setText("结果：" + edt_01.getText().toString() + "等于" + edt_02.getText().toString());
                        break;
                    case 1:
                        tv_result.setText("结果：" + edt_01.getText().toString() + "大于" + edt_02.getText().toString());
                        break;
                    case 2:
                        tv_result.setText("结果：出错");
                        break;
                }
                break;
        }
    }

    /**
     * 比较两个金额的大小
     *
     * @param a
     * @param b
     * @return
     */
    private String getMoneyCheckStr(String a, String b) {

        return "";
    }
}