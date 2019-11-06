package com.example.edz.mvp;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.edz.mvp.bean.MyBanner;
import com.example.edz.mvp.bean.Result;
import com.example.edz.mvp.presenter.MyBannerPresenter;
import com.example.edz.mvp.utils.DataCall;
import com.example.edz.mvp.utils.exception.ApiException;
import com.example.edz.mvp.utils.util.WDActivity;
import com.zhouwei.mzbanner.MZBannerView;
import com.zhouwei.mzbanner.holder.MZHolderCreator;
import com.zhouwei.mzbanner.holder.MZViewHolder;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends WDActivity {


    private TextView mybanner;
    private MZBannerView banner;
    private MyBannerPresenter myBannerPresenter;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        mybanner = findViewById(R.id.mybanner);
        myBannerPresenter = new MyBannerPresenter(new MyBannerCall());

        mybanner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myBannerPresenter.reqeust();
            }
        });

    }

    @Override
    protected void destoryData() {
        myBannerPresenter.unBind();
    }

    private class MyBannerCall implements DataCall<Result<List<MyBanner>>> {
        @Override
        public void success(Result<List<MyBanner>> data) {
            mybanner.setText(data.getResult().get(0).getTitle());

            for (int i = 0; i < data.getResult().size(); i++) {
                imgs.add(data.getResult().get(i).getImg_url());
            }
            banner = findViewById(R.id.banner);
            // 设置数据
            banner.setPages(imgs, new MZHolderCreator<BannerViewHolder>() {
                @Override
                public BannerViewHolder createViewHolder() {
                    return new BannerViewHolder();
                }
            });


//            imgs.add("http://img1.imgtn.bdimg.com/it/u=4194723123,4160931506&fm=200&gp=0.jpg");
//            imgs.add("http://img1.imgtn.bdimg.com/it/u=4194723123,4160931506&fm=20&gp=0.jpg");
//            imgs.add("http://img1.imgtn.bdimg.com/it/u=4194723123,4160931506&fm=30&gp=0.jpg");
        }

        @Override
        public void fail(ApiException e) {

        }
    }


    List imgs = new ArrayList<>();

    public class BannerViewHolder implements MZViewHolder<String> {
        private ImageView mImageView;

        @Override
        public View createView(Context context) {
            // 返回页面布局
            View view = LayoutInflater.from(context).inflate(R.layout.banner_iteam, null);
            mImageView = (ImageView) view.findViewById(R.id.banner_image);
            return view;
        }

        @Override
        public void onBind(Context context, int i, String resultBean) {
            Glide.with(context).load(resultBean).into(mImageView);
        }
    }
}
