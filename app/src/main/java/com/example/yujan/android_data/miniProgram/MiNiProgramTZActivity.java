package com.example.yujan.android_data.miniProgram;

import android.os.Bundle;
import android.view.View;

import com.example.yujan.android_data.R;
import com.example.yujan.android_data.sjms.base.BaseActivity;
import com.tencent.mm.opensdk.modelbiz.WXLaunchMiniProgram;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;


public class MiNiProgramTZActivity extends BaseActivity implements View.OnClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mi_ni_program_tz);
        findViewById(R.id.btn_to_wx_mini_program).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_to_wx_mini_program:
                toWxMiniProgram();
                break;
        }
    }

    /**
     * 跳转到指定微信小程序
     */
    private void toWxMiniProgram() {
        String appId = "wx5bb986a31871fb9f"; // 应用AppId
        IWXAPI api = WXAPIFactory.createWXAPI(MiNiProgramTZActivity.this, appId);
        WXLaunchMiniProgram.Req req = new WXLaunchMiniProgram.Req();
        req.userName = "gh_2bf0edbe7bb6"; // 填小程序原始id
//        req.path = "pages/index/index"; //拉起小程序页面的可带参路径，不填默认拉起小程序首页
        req.miniprogramType = WXLaunchMiniProgram.Req.MINIPROGRAM_TYPE_TEST;// 可选打开 WXMiniProgramTypeRelease 正式版    WXMiniProgramTypeTest 开发版    WXMiniProgramTypePreview 体验版
        api.sendReq(req);
    }
}
