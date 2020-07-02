package com.example.yujan.android_data.banner.bean;

import java.io.Serializable;

/**
 * Created by yujan on 2020/7/2.
 */

public class BannerBean implements Serializable {
    private String url;
    private int type;//1:视频  2:图片

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
