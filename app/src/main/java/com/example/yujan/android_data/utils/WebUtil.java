package com.example.yujan.android_data.utils;

import android.text.TextUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WebUtil {
    /**
     * 返回字符串中包含的url
     *
     * @param data
     * @return
     */
    public static List<String> findUrlByStr(String data) {
        List<String> urls = new ArrayList<>();
        if (TextUtils.isEmpty(data)) return urls;
        Pattern pattern = Pattern.compile("(http|https|ftp)://[a-zA-Z0-9\\-\\.]+\\.[a-zA-Z]{2,3}(:[a-zA-Z0-9]*)?([:a-zA-Z0-9\\-\\._?\\,'\\+&$*%$#/=~])*");
        Matcher matcher = pattern.matcher(data);
        while (matcher.find()) {
            urls.add(matcher.group());
        }
        return urls;
    }
}
