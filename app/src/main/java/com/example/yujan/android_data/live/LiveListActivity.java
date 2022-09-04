package com.example.yujan.android_data.live;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.example.yujan.android_data.R;
import com.example.yujan.android_data.sjms.base.BaseActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LiveListActivity extends BaseActivity {
    private ListView lv_live;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_live_list);
        lv_live = findViewById(R.id.lv_live);
        initLisener();
        setData();
    }

    /**
     * 添加数据
     */
    private void setData() {
        List<Map<String, Object>> list = new ArrayList<>();
        String[] types = getResources().getStringArray(R.array.live_type);
        for (int i = 0; i < types.length; i++) {
            Map<String, Object> map = new HashMap<>();
            map.put("type", types[i]);
            list.add(map);
        }
        lv_live.setAdapter(new SimpleAdapter(this,
                list,
                R.layout.layout_main_lv_item,
                new String[]{"type"},
                new int[]{R.id.tv_title}));
    }

    /**
     * lv监听
     */
    private void initLisener() {
        lv_live.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    //腾讯
                    case 0:
                        startActivity(new Intent(LiveListActivity.this, TencentLiveActivity.class));
                        break;
                    //七鱼客服
                    case 1:
                        startActivity(new Intent(LiveListActivity.this, QiYuKFActivity.class));
                        break;
                }
            }
        });
    }
}
