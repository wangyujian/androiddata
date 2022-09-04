package com.example.yujan.android_data.live;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.yujan.android_data.R;
import com.google.gson.Gson;
import com.qiyukf.nimlib.sdk.RequestCallback;
import com.qiyukf.unicorn.api.ConsultSource;
import com.qiyukf.unicorn.api.QuickEntry;
import com.qiyukf.unicorn.api.QuickEntryListener;
import com.qiyukf.unicorn.api.Unicorn;
import com.qiyukf.unicorn.api.YSFOptions;
import com.qiyukf.unicorn.api.YSFUserInfo;

import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;

public class QiYuKFActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qi_yu_kfactivity);
        findViewById(R.id.btn_kf).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    openQiYuKF();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private void openQiYuKF() throws JSONException {
        YSFUserInfo userInfoA = new YSFUserInfo();
        userInfoA.userId = "000001";
        userInfoA.data = userInfoData("行有道新用户001", "18616256666", "");
        Unicorn.setUserInfo(userInfoA, new RequestCallback<Void>() {
            @Override
            public void onSuccess(Void unused) {
                String title = "";
/**
 * 设置访客来源，标识访客是从哪个页面发起咨询的，用于客服了解用户是从什么页面进入。
 * 三个参数分别为：来源页面的url，来源页面标题，来源页面额外信息（保留字段，暂时无用）。
 * 设置来源后，在客服会话界面的"用户资料"栏的页面项，可以看到这里设置的值。
 */
                ConsultSource source = new ConsultSource("https://image.baidu.com/search/albumsdetail?tn=albumsdetail&word=%E5%AE%A0%E7%89%A9%E5%9B%BE%E7%89%87&fr=albumslist&album_tab=%E5%8A%A8%E7%89%A9&album_id=688&rn=30", "行有道客服-小美", "custom information string");
//                source.quickEntryList = new ArrayList<>();
//                source.quickEntryList.add(new QuickEntry(0, "退款", ""));
//                source.quickEntryList.add(new QuickEntry(1, "订单列表", ""));
//                source.quickEntryList.add(new QuickEntry(2, "平台活动", ""));

/**
 * 请注意： 调用该接口前，应先检查Unicorn.isServiceAvailable()，
 * 如果返回为false，该接口不会有任何动作
 *
 * @param context 上下文
 * @param title   聊天窗口的标题
 * @param source  咨询的发起来源，包括发起咨询的url，title，描述信息等
 */
                Unicorn.openServiceActivity(QiYuKFActivity.this, title, source);
                YSFOptions options = new YSFOptions();
                options.quickEntryListener = new QuickEntryListener() {
                    @Override
                    public void onClick(Context context, String shopId, QuickEntry quickEntry) {
                        Toast.makeText(context, "点击快捷入口" + quickEntry.getId(), Toast.LENGTH_LONG).show();
                        if (quickEntry.getId() == 0) {
                            // 这里可根据 QuickEntry 做出相应的相应，如打开订单选择窗口
                        }
                    }
                };
            }

            @Override
            public void onFailed(int i) {

            }

            @Override
            public void onException(Throwable throwable) {

            }
        });

    }

    /**
     * 构造用户信息
     *
     * @param name   名字
     * @param mobile 手机
     * @param avatar 头像
     * @return
     */
    private static String userInfoData(String name, String mobile, String avatar) {
        List<YSFUser> mListUser = new ArrayList<>();
        YSFUser rName = new YSFUser("real_name", name);
        YSFUser rMoblie = new YSFUser("mobile_phone", mobile);
        YSFUser rAvatar = new YSFUser("avatar", avatar);
        mListUser.add(rName);
        mListUser.add(rMoblie);
        mListUser.add(rAvatar);
        return new Gson().toJson(mListUser);
    }

    /**
     * 七鱼用户信息
     */
    public static class YSFUser {
        String key;
        String value;

        public YSFUser(String key, String value) {
            this.key = key;
            this.value = value;
        }

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }

}