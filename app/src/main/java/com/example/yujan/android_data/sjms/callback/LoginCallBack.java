package com.example.yujan.android_data.sjms.callback;

import com.example.yujan.android_data.sjms.bean.UserInfoBean;

/**
 * Created by yujan on 2020/3/27.
 */

public interface LoginCallBack {
    /**
     * 登录成功
     *
     * @param bean 用户数据
     */
    void onSuccess(UserInfoBean bean);

    /**
     * 登录失败
     */
    void onFailed();
}
