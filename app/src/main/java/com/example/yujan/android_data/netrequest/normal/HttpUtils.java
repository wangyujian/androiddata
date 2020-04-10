package com.example.yujan.android_data.netrequest.normal;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by yujan on 2020/4/1.
 */

public class HttpUtils {
    /**
     * 返回sendUrl对应网址的内容
     *
     * @param sendUrl
     * @return
     */
    public static String sendRul(String sendUrl) {
        try {
            URL url = new URL(sendUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            //连接超时时间
            conn.setReadTimeout(5 * 1000);
            conn.setRequestMethod("GET");
            //获取数据
            InputStream stream = conn.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
            StringBuffer buffer = new StringBuffer();
            String str = null;
            while ((str = reader.readLine()) != null) {
                buffer.append(str);
            }
            return buffer.toString();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 返回sendUrl对应图片的内容
     *
     * @param sendUrl
     * @return
     */
    public static Bitmap loadImage(String sendUrl) {
        try {
            URL url = new URL(sendUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            //连接超时时间
            conn.setReadTimeout(5 * 1000);
            conn.setRequestMethod("GET");
            //获取数据 转换成Bitmap并返回
            InputStream stream = conn.getInputStream();
            String fileName = String.valueOf(System.currentTimeMillis());
            FileOutputStream outputStream = null;
            File fileDownLoad = null;
            if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
                File parent = Environment.getExternalStorageDirectory();
                fileDownLoad = new File(parent, fileName);
                outputStream = new FileOutputStream(fileDownLoad);
            }
            byte[] bytes = new byte[2 * 1024];
            int lens;
            if (outputStream != null) {
                while ((lens = stream.read(bytes)) != -1) {
                    outputStream.write(bytes, 0, lens);
                }
                return BitmapFactory.decodeFile(fileDownLoad.getAbsolutePath());
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
