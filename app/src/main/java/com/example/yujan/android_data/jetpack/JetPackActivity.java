package com.example.yujan.android_data.jetpack;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.yujan.android_data.R;
import com.example.yujan.android_data.sjms.base.BaseActivity;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

/**
 * JetPack相关的操作库
 */
public class JetPackActivity extends BaseActivity {
    private static final String TAG = "JetPackActivity";
    private MutableLiveData<String> mutableLiveData = new MutableLiveData<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jet_pack);
        //注册观察者 监听事件变化
        mutableLiveData.observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                Toast.makeText(JetPackActivity.this, s, Toast.LENGTH_LONG).show();
            }
        });
        findViewById(R.id.btn_send).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //发送数据变化
                mutableLiveData.setValue("hhahha");
            }
        });
    }
}