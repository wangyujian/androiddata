package com.example.yujan.android_data.banner;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

import com.bumptech.glide.Glide;
import com.example.yujan.android_data.R;
import com.example.yujan.android_data.banner.bean.BannerBean;
import com.example.yujan.android_data.sjms.base.BaseActivity;

import java.util.ArrayList;

import cn.bingoogolapple.bgabanner.BGABanner;

public class BannerVideoImgActivity extends BaseActivity {
    private BGABanner banner;
    private VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_banner_video_img);
        banner = findViewById(R.id.banner);
        setData();
    }

    private void setData() {
//        List<ViewItemBean> list = new ArrayList<>();
//        ViewItemBean itemBean1 = new ViewItemBean(
//                BannerConfig.VIDEO,
//                "这是一个视频",
//                "https://v-cdn.zjol.com.cn/280443.mp4",
//                1000 * 1000
//        );
//        list.add(itemBean1);
//        ViewItemBean itemBean2 = new ViewItemBean(
//                BannerConfig.IMAGE,
//                "这是一张图片",
//                "https://fanyiapp.cdn.bcebos.com/cms/image/7f182104dfd7b567442affa2ee3e73d5.jpg",
//                5* 1000
//        );
//        list.add(itemBean2);
        banner.setAdapter(new BGABanner.Adapter<View, BannerBean>() {
            @Override
            public void fillBannerItem(BGABanner banner, View itemView, @Nullable BannerBean model, int position) {
                if (model.getType() == 1) {
                    ImageView video = itemView.findViewById(R.id.video);
                    Glide.with(BannerVideoImgActivity.this).load(model.getUrl()).into(video);
                } else {
                    if (videoView != null && videoView.isPlaying()) {
                        videoView.pause();
//                        banner.setCurrentItem(position);
                    }
                    ImageView img = itemView.findViewById(R.id.img);
                    Glide.with(BannerVideoImgActivity.this).load(model.getUrl()).into(img);
                }
            }
        });
        banner.setDelegate(new BGABanner.Delegate<View, BannerBean>() {
            @Override
            public void onBannerItemClick(BGABanner banner, View itemView, @Nullable BannerBean model, int position) {
                Toast.makeText(BannerVideoImgActivity.this, position + "", Toast.LENGTH_LONG).show();

                if (model.getType() == 1) {
                    ImageView video = itemView.findViewById(R.id.video);
                    videoView = itemView.findViewById(R.id.video_view);
                    video.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Toast.makeText(BannerVideoImgActivity.this, "点击了图片", Toast.LENGTH_LONG).show();
                            //添加播放控制条,还是自定义好点
                            videoView.setMediaController(new MediaController(BannerVideoImgActivity.this));

                            Uri mVideoUri = Uri.parse("https://v-cdn.zjol.com.cn/280443.mp4");
                            videoView.setVideoPath(mVideoUri.toString());

                            videoView.start();
                            videoView.requestFocus();
                        }
                    });
                }
            }
        });
        ArrayList<View> views = new ArrayList();
        String[] urls = {"https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=2021282914,3070883846&fm=26&gp=0.jpg",
                "https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=2832888014,838610565&fm=26&gp=0.jpg",
                "https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=2757134479,2888322557&fm=26&gp=0.jpg"};
        ArrayList<BannerBean> bannerBeans = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            BannerBean bannerBean = new BannerBean();
            bannerBean.setUrl(urls[i]);
            if (i == 0) {
                View video = LayoutInflater.from(this).inflate(R.layout.banner_video_item, null);
                views.add(video);
                bannerBean.setType(1);
            } else {
                View img = LayoutInflater.from(this).inflate(R.layout.banner_img_item, null);
                views.add(img);
                bannerBean.setType(0);
            }
            bannerBeans.add(bannerBean);
        }
        banner.setData(views, bannerBeans, null);
        banner.setAutoPlayAble(false);
    }
}
