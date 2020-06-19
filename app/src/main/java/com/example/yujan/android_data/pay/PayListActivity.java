package com.example.yujan.android_data.pay;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.example.yujan.android_data.R;
import com.example.yujan.android_data.netrequest.NetRequestActivity;
import com.example.yujan.android_data.netrequest.normal.HttpTestActivity;
import com.example.yujan.android_data.netrequest.okhttp.OkhttpRequestActivity;
import com.example.yujan.android_data.netrequest.okhttppackage1.OkhttpPackage1Activity;
import com.example.yujan.android_data.pay.alipay.PayDemoActivity;
import com.example.yujan.android_data.sjms.base.BaseActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PayListActivity extends BaseActivity {
    private ListView lv_pay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay_list);
        lv_pay = findViewById(R.id.lv_pay);
        initLisener();
        setData();
    }

    /**
     * 添加数据
     */
    private void setData() {
        List<Map<String, Object>> list = new ArrayList<>();
        String[] types = getResources().getStringArray(R.array.pay_type);
        for (int i = 0; i < types.length; i++) {
            Map<String, Object> map = new HashMap<>();
            map.put("type", types[i]);
            list.add(map);
        }
        lv_pay.setAdapter(new SimpleAdapter(this,
                list,
                R.layout.layout_main_lv_item,
                new String[]{"type"},
                new int[]{R.id.tv_title}));
    }

    /**
     * lv监听
     */
    private void initLisener() {
        lv_pay.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    //支付宝
                    case 0:
                        startActivity(new Intent(PayListActivity.this, PayDemoActivity.class));
                        break;
                }
            }
        });
    }
}
