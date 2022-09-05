package com.example.yujan.android_data.cache;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.example.yujan.android_data.R;
import com.example.yujan.android_data.cache.recycler_view.RecyclerViewActivity;
import com.example.yujan.android_data.sjms.base.BaseActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CacheListActivity extends BaseActivity {
    private ListView lv_cache;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cache_list);
        lv_cache = findViewById(R.id.lv_cache);
        setData();
        initListener();
    }

    private void setData() {
        List<Map<String, Object>> list = new ArrayList<>();
        String[] types = getResources().getStringArray(R.array.cache);
        for (int i = 0; i < types.length; i++) {
            Map<String, Object> map = new HashMap<>();
            map.put("type", types[i]);
            list.add(map);
        }
        lv_cache.setAdapter(new SimpleAdapter(this,
                list,
                R.layout.layout_main_lv_item,
                new String[]{"type"},
                new int[]{R.id.tv_title}));

    }

    private void initListener() {
        lv_cache.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        startActivity(new Intent(CacheListActivity.this, RecyclerViewActivity.class));
                        break;
                }
            }
        });
    }
}