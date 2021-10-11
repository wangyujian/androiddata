package com.example.yujan.android_data.utils;

import android.text.TextUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateUtil {
    /**
     * 效验手机号合法性
     *
     * @param mobiles
     * @return
     */
    public static boolean isMobileNO(String mobiles) {
        if (TextUtils.isEmpty(mobiles)) return false;
        Pattern p = Pattern.compile("^((13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$");
        Matcher m = p.matcher(mobiles);
        return m.matches();
    }

    /**
     * 效验邮箱合法性
     *
     * @param mobiles
     * @return
     */
    public static boolean isMail(String mobiles) {
        if (TextUtils.isEmpty(mobiles)) return false;
        Pattern p = Pattern.compile("^([a-z0-9A-Z]+[-|_|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$");
        Matcher m = p.matcher(mobiles);
        return m.matches();
    }
    /**
     * 效验身份证合法性
     *
     * @param idCard
     * @return
     */
    public static boolean isIdCard(String idCard) {
        if (TextUtils.isEmpty(idCard)) return false;
        Pattern p = Pattern.compile("\\d{17}[\\d|x|X]|\\d{15}");
        Matcher m = p.matcher(idCard);
        return m.matches();
    }
}
