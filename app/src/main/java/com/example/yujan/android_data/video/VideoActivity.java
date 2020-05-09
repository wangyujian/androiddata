package com.example.yujan.android_data.video;

import android.os.Bundle;
import android.os.Environment;

import com.example.yujan.android_data.R;
import com.example.yujan.android_data.sjms.base.BaseActivity;

import java.io.File;

public class VideoActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
        videoManger();
    }

    private void videoManger() {
        String path = Environment.getExternalStorageDirectory().getPath() + File.separator + "DCIM" + File.separator + "Camera" + File.separator + "4129d7a1c79aa9c2a9a587fa3e6ff3e3.mp4";
        File file = new File(path);

        String pathImg = Environment.getExternalStorageDirectory().getPath() + File.separator + "DCIM" + File.separator + "Camera" + File.separator + "IMG_20181218_134015.jpg";
        File fileImg = new File(pathImg);



    }
}
