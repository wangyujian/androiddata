package com.example.yujan.android_data.sjms.mvvm;

import android.app.Application;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;
import com.example.yujan.android_data.BR;
import com.example.yujan.android_data.databinding.ActivityMvvmBinding;
import com.example.yujan.android_data.sjms.bean.UserInfoBean;
import com.example.yujan.android_data.sjms.callback.LoginCallBack;

/**
 * Created by yujan on 2020/3/31.
 */

public class MVVMViewModel extends BaseObservable {
    private MVVMModel mvvmModel;
    private String result;
    private String userInput;
    private Application application;
    private ActivityMvvmBinding binding;

    public MVVMViewModel(Application application, ActivityMvvmBinding binding) {
        mvvmModel = new MVVMModel();
        this.application = application;
        this.binding = binding;
        setResult("登录状态：");
    }

    public void getData(View view) {
        String string = binding.edtInput.getText().toString();
        if (TextUtils.isEmpty(string)) {
            Toast.makeText(application, "请输入用户名", Toast.LENGTH_SHORT).show();
            return;
        }
        mvvmModel.getUserLoginInfo(string, new LoginCallBack() {
            @Override
            public void onSuccess(UserInfoBean userInfoBean) {
                setResult("登录转态：\n用户名："
                        + userInfoBean.getName()
                        + ",用户等级："
                        + userInfoBean.getLevel());
            }

            @Override
            public void onFailed() {
                setResult("登录转态：\n登录失败");
            }
        });
    }

    @Bindable
    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
        notifyPropertyChanged(BR.result);
    }


    @Bindable
    public String getUserInput() {
        return userInput;
    }

    public void setUserInput(String userInput) {
        this.userInput = userInput;
        notifyPropertyChanged(BR.userInput);
    }
}
