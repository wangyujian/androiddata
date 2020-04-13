package com.example.yujan.android_data.sjms;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.example.yujan.android_data.R;
import com.example.yujan.android_data.sjms.base.BaseActivity;
import com.example.yujan.android_data.sjms.mvc.MVCActivity;
import com.example.yujan.android_data.sjms.mvp.MVPActivity;
import com.example.yujan.android_data.sjms.mvvm.MVVMActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 1）如果项目简单，没什么复杂性，未来改动也不大的话，那就不要用设计模式或者架构方法，只需要将每个模块封装好，方便调用即可，不要为了使用设计模式或架构方法而使用。
 * 2）对于偏向展示型的app，绝大多数业务逻辑都在后端，app主要功能就是展示数据，交互等，建议使用mvvm。
 * 3）对于工具类或者需要写很多业务逻辑app，使用mvp或者mvvm都可。
 * 4）如果想通过一个项目去学习架构和设计模式，建议用MVC然后在此基础上慢慢挖掘改进。最后你可能发现，改进的最终结果可能就变成了mvp，mvvm。
 */
public class SJMSActivity extends BaseActivity {

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
        String[] types = getResources().getStringArray(R.array.sjms_type);
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
                    //MVVM架构设计模式
                    case 3:
                        startActivity(new Intent(SJMSActivity.this, MVVMActivity.class));
                        break;
                }
            }
        });
    }
}
