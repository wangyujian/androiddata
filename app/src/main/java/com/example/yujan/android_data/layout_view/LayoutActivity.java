package com.example.yujan.android_data.layout_view;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.example.yujan.android_data.R;
import com.tencent.mm.opensdk.utils.Log;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class LayoutActivity extends AppCompatActivity {
    private ListView lv_layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout);
        lv_layout = findViewById(R.id.lv_layout);
        initLisener();
        setData();
        Log.i("生命周期：", "--------onCreate");
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState, @NonNull PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        Log.i("onSaveInstanceState：--------", outState.toString());
    }

    /**
     * 添加数据
     */
    private void setData() {
        List<Map<String, Object>> list = new ArrayList<>();
        String[] types = getResources().getStringArray(R.array.layout_type);
        for (int i = 0; i < types.length; i++) {
            Map<String, Object> map = new HashMap<>();
            map.put("type", types[i]);
            list.add(map);
        }
        lv_layout.setAdapter(new SimpleAdapter(this,
                list,
                R.layout.layout_main_lv_item,
                new String[]{"type"},
                new int[]{R.id.tv_title}));
    }

    /**
     * lv监听
     */
    private void initLisener() {
        lv_layout.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    //ConstraintLayout
                    case 0:
                        startActivity(new Intent(LayoutActivity.this, ConstraintLayoutActivity.class));
                        break;
                }
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("生命周期：", "--------onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("生命周期：", "--------onResume");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("生命周期：", "--------onRestart");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("生命周期：", "--------onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("生命周期：", "--------onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("生命周期：", "--------onDestroy");
    }

}