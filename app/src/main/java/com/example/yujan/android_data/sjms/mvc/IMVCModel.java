package com.example.yujan.android_data.sjms.mvc;

import com.example.yujan.android_data.sjms.bean.UserInfoBean;
import com.example.yujan.android_data.sjms.callback.LoginCallBack;

import java.util.Random;

/**
 * Created by yujan on 2020/3/27.
 */

public class IMVCModel {
    /**
     * 获取用户登录信息（模拟）
     *
     * @param userName
     * @param callBack
     */
    public void getUserLoginInfo(String userName, LoginCallBack callBack) {
        Random random = new Random();
        boolean bool = random.nextBoolean();
        if (bool) {
            callBack.onSuccess(new UserInfoBean(userName, 2));
        } else {
            callBack.onFailed();
        }
    }
}
