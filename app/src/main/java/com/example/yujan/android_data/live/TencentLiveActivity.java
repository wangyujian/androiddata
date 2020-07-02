package com.example.yujan.android_data.live;

import android.os.Bundle;

import com.example.yujan.android_data.R;
import com.example.yujan.android_data.sjms.base.BaseActivity;
import com.tencent.rtmp.TXLivePlayer;

public class TencentLiveActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tencent_live);
        TXLivePlayer txLivePlayer=new TXLivePlayer(this);
//        txLivePlayer.startPlay();
    }
}
