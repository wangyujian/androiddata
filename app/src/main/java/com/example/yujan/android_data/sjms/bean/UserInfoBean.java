package com.example.yujan.android_data.sjms.bean;

/**
 * Created by yujan on 2020/3/27.
 */

public class UserInfoBean {
    private String name="nihao";
    private int level;

    public UserInfoBean(String name, int level) {
        this.name = name;
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }
}
