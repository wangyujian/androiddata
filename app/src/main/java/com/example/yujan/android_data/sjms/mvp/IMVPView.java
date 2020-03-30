package com.example.yujan.android_data.sjms.mvp;

import com.example.yujan.android_data.sjms.bean.UserInfoBean;

/**
 * Created by yujan on 2020/3/30.
 */

public interface IMVPView {
    String getUserInputInfo();

    void updateLoginSuccessView(UserInfoBean bean);

    void updateLoginFailView();
}
