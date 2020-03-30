package com.example.yujan.android_data.sjms.mvp;

import android.text.TextUtils;

import com.example.yujan.android_data.sjms.bean.UserInfoBean;
import com.example.yujan.android_data.sjms.callback.LoginCallBack;

/**
 * Created by yujan on 2020/3/30.
 */

public class IMVPPresenter {
    private IMVPView imvpView;
    private IMVPModel imvpModel;

    public IMVPPresenter(IMVPView imvpView) {
        this.imvpView = imvpView;
        imvpModel = new IMVPModel();
    }

    public void getData(String str) {
        if (!TextUtils.isEmpty(str)) {
            imvpModel.getUserLoginInfo(str, new LoginCallBack() {
                @Override
                public void onSuccess(UserInfoBean bean) {
                    imvpView.updateLoginSuccessView(bean);
                }

                @Override
                public void onFailed() {
                    imvpView.updateLoginFailView();
                }
            });
        }
    }
}
