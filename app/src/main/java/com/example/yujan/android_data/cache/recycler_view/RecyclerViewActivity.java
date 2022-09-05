package com.example.yujan.android_data.cache.recycler_view;

import android.os.Bundle;

import com.example.yujan.android_data.R;
import com.example.yujan.android_data.sjms.base.BaseActivity;

import java.util.Arrays;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerViewActivity extends BaseActivity {
    private RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        rv=findViewById(R.id.rv);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        rv.setLayoutManager(manager);
        rv.setAdapter(new RecyclerViewAdapter(Arrays.asList(
                "https://upload-images.jianshu.io/upload_images/6013874-23b92cd88e640224.jpg?imageMogr2/auto-orient/strip|imageView2/1/w/300/h/240/format/webp"
                ,"https://upload-images.jianshu.io/upload_images/7702806-4ded443990861990.jpg?imageMogr2/auto-orient/strip|imageView2/1/w/360/h/240"
                 ,"https://t7.baidu.com/it/u=1285847167,3193778276&fm=193&f=GIF"
                ,"https://t7.baidu.com/it/u=2487758541,1861252964&fm=193&f=GIF"
                ,"https://t7.baidu.com/it/u=813347183,2158335217&fm=193&f=GIF"
                ,"https://t7.baidu.com/it/u=1873319202,3714092135&fm=193&f=GIF"
                ,"https://t7.baidu.com/it/u=3868018280,3177353405&fm=193&f=GIF"

        ),RecyclerViewActivity.this));
    }
}