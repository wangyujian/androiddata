package com.example.yujan.android_data.base;

/**
 * Created by yujan on 2020/4/26.
 */

public interface ApplicationIml {
    /**
     * 异常捕获
     */
    void initException();

    /**
     * 配置 License 授权(腾讯移动直播)
     */
    void initTencentLive();

    /**
     * 网易七鱼
     */
    void initQiYuKF();
}
