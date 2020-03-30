package com.example.yujan.android_data.sjms;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.example.yujan.android_data.R;
import com.example.yujan.android_data.sjms.mvc.MVCActivity;
import com.example.yujan.android_data.sjms.mvp.MVPActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SJMSActivity extends AppCompatActivity {

    private ListView lv_sjms;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sjms);
        lv_sjms = findViewById(R.id.lv_sjms);
        initLisener();
        setData();
    }

    /**
     * 添加数据
     */
    private void setData() {
        List<Map<String, Object>> list = new ArrayList<>();
        String[] types = getResources().getStringArray(R.array.main_sjms);
        for (int i = 0; i < types.length; i++) {
            Map<String, Object> map = new HashMap<>();
            map.put("type", types[i]);
            list.add(map);
        }
        lv_sjms.setAdapter(new SimpleAdapter(this,
                list,
                R.layout.layout_main_lv_item,
                new String[]{"type"},
                new int[]{R.id.tv_title}));
    }

    /**
     * lv监听
     */
    private void initLisener() {
        lv_sjms.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    //无任何架构设计模式
                    case 0:
                        startActivity(new Intent(SJMSActivity.this, NormalActivity.class));
                        break;
                    //MVC架构设计模式
                    case 1:
                        startActivity(new Intent(SJMSActivity.this, MVCActivity.class));
                        break;
                    //MVP架构设计模式
                    case 2:
                        startActivity(new Intent(SJMSActivity.this, MVPActivity.class));
                        break;
                }
            }
        });
    }
}
