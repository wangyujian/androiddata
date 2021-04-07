package com.example.yujan.android_data;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.example.yujan.android_data.banner.BannerActivity;
import com.example.yujan.android_data.chart.ChartActivity;
import com.example.yujan.android_data.exception.ExceptionActivity;
import com.example.yujan.android_data.jsonparse.JsonParseActivity;
import com.example.yujan.android_data.live.LiveListActivity;
import com.example.yujan.android_data.miniProgram.MiNiProgramTypeActivity;
import com.example.yujan.android_data.netrequest.NetRequestActivity;
import com.example.yujan.android_data.pay.PayListActivity;
import com.example.yujan.android_data.sjms.SJMSActivity;
import com.example.yujan.android_data.sjms.base.BaseActivity;
import com.example.yujan.android_data.tab.TabListActivity;
import com.example.yujan.android_data.video.VideoMainActivity;
import com.example.yujan.android_data.watermark.WaterMarkActivity;
import com.example.yujan.android_data.webview.WebViewActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends BaseActivity {

    private ListView lv_type;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv_type = findViewById(R.id.lv_type);
        initLisener();
        setData();
    }

    /**
     * 添加数据
     */
    private void setData() {
        List<Map<String, Object>> list = new ArrayList<>();
        String[] types = getResources().getStringArray(R.array.main_type);
        for (int i = 0; i < types.length; i++) {
            Map<String, Object> map = new HashMap<>();
            map.put("type", types[i]);
            list.add(map);
        }
        lv_type.setAdapter(new SimpleAdapter(this,
                list,
                R.layout.layout_main_lv_item,
                new String[]{"type"},
                new int[]{R.id.tv_title}));
    }

    /**
     * lv监听
     */
    private void initLisener() {
        lv_type.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    //MVC/MVP/MVVM架构设计模式
                    case 0:
                        startActivity(new Intent(MainActivity.this, SJMSActivity.class));
                        break;
                    //网络请求
                    case 1:
                        startActivity(new Intent(MainActivity.this, NetRequestActivity.class));
                        break;
                    //Json解析
                    case 2:
                        startActivity(new Intent(MainActivity.this, JsonParseActivity.class));
                        break;
                    //异常处理
                    case 3:
                        startActivity(new Intent(MainActivity.this, ExceptionActivity.class));
                        break;
                    //音视频处理
                    case 4:
                        startActivity(new Intent(MainActivity.this, VideoMainActivity.class));
                        break;
                    //WebView
                    case 5:
                        startActivity(new Intent(MainActivity.this, WebViewActivity.class));
                        break;
                    //支付
                    case 6:
                        startActivity(new Intent(MainActivity.this, PayListActivity.class));
                        break;
                    //轮播图
                    case 7:
                        startActivity(new Intent(MainActivity.this, BannerActivity.class));
                        break;
                    //直播
                    case 8:
                        startActivity(new Intent(MainActivity.this, LiveListActivity.class));
                        break;
                    //微信小程序
                    case 9:
                        startActivity(new Intent(MainActivity.this, MiNiProgramTypeActivity.class));
                        break;
                    //表格
                    case 10:
                        startActivity(new Intent(MainActivity.this, ChartActivity.class));
                        break;
                    //表格
                    case 11:
                        startActivity(new Intent(MainActivity.this, TabListActivity.class));
                        break;
                    //kotlin
                    case 12:
                        break;
                    //水印
                    case 13:
                        startActivity(new Intent(MainActivity.this, WaterMarkActivity.class));
                        break;
                }
            }
        });
    }
}
