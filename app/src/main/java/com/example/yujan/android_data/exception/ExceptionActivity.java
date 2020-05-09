package com.example.yujan.android_data.exception;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.yujan.android_data.R;

import org.w3c.dom.Text;

import java.io.Serializable;

public class ExceptionActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView tv_exception_api_result;
    private TextView tv_exception_third_party_result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exception);
        tv_exception_api_result = findViewById(R.id.tv_exception_api_result);
        tv_exception_third_party_result = findViewById(R.id.tv_exception_third_party_result);
        findViewById(R.id.btn_exception_api).setOnClickListener(this);
        findViewById(R.id.btn_exception_third_party).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_exception_api:
                ExceptionVo exceptionVo = null;
                exceptionVo.getExceptionId();
                break;
            case R.id.btn_exception_third_party:

                break;
        }
    }

    public class ExceptionVo implements Serializable {
        private long exceptionId;
        private String exceptionStr;

        public long getExceptionId() {
            return exceptionId;
        }

        public void setExceptionId(long exceptionId) {
            this.exceptionId = exceptionId;
        }

        public String getExceptionStr() {
            return exceptionStr;
        }

        public void setExceptionStr(String exceptionStr) {
            this.exceptionStr = exceptionStr;
        }
    }
}
