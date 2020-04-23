package com.example.yujan.android_data.netrequest.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by yujan on 2020/4/23.
 */

public class RequestBody<T> implements Serializable {
    private List<T> data;

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}
