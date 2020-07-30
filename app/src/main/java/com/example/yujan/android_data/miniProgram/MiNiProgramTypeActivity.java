package com.example.yujan.android_data.miniProgram;

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

public class MiNiProgramTypeActivity extends BaseActivity {

    private ListView lv_mi_ni_program;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mi_ni_program_type);
        lv_mi_ni_program = findViewById(R.id.lv_mi_ni_program);
        initLisener();
        setData();
    }

    /**
     * 添加数据
     */
    private void setData() {
        List<Map<String, Object>> list = new ArrayList<>();
        String[] types = getResources().getStringArray(R.array.wx_mini_program);
        for (int i = 0; i < types.length; i++) {
            Map<String, Object> map = new HashMap<>();
            map.put("type", types[i]);
            list.add(map);
        }
        lv_mi_ni_program.setAdapter(new SimpleAdapter(this,
                list,
                R.layout.layout_main_lv_item,
                new String[]{"type"},
                new int[]{R.id.tv_title}));
    }

    /**
     * lv监听
     */
    private void initLisener() {
        lv_mi_ni_program.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    //android跳转到微信小程序
                    case 0:
                        startActivity(new Intent(MiNiProgramTypeActivity.this, MiNiProgramTZActivity.class));
                        break;
                }
            }
        });
    }
}
