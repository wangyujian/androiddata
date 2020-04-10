package com.example.yujan.android_data.netrequest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.example.yujan.android_data.R;
import com.example.yujan.android_data.netrequest.normal.HttpTestActivity;
import com.example.yujan.android_data.netrequest.okhttp.OkhttpRequestActivity;
import com.example.yujan.android_data.sjms.NormalActivity;
import com.example.yujan.android_data.sjms.mvc.MVCActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NetRequestActivity extends AppCompatActivity {
    private ListView lv_net_request;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_net_request);
        lv_net_request = findViewById(R.id.lv_net_request);
        initLisener();
        setData();
    }

    /**
     * 添加数据
     */
    private void setData() {
        List<Map<String, Object>> list = new ArrayList<>();
        String[] types = getResources().getStringArray(R.array.net_request_type);
        for (int i = 0; i < types.length; i++) {
            Map<String, Object> map = new HashMap<>();
            map.put("type", types[i]);
            list.add(map);
        }
        lv_net_request.setAdapter(new SimpleAdapter(this,
                list,
                R.layout.layout_main_lv_item,
                new String[]{"type"},
                new int[]{R.id.tv_title}));
    }

    /**
     * lv监听
     */
    private void initLisener() {
        lv_net_request.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    //普通的网络请求
                    case 0:
                        startActivity(new Intent(NetRequestActivity.this, HttpTestActivity.class));
                        break;
                    //okhttp网络请求
                    case 1:
                        startActivity(new Intent(NetRequestActivity.this, OkhttpRequestActivity.class));
                        break;
                }
            }
        });
    }
}
