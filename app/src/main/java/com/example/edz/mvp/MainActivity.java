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
import com.example.edz.mvp.utils.util.BaseActivity;
import com.example.edz.mvp.utils.util.WDActivity;
import com.zhouwei.mzbanner.MZBannerView;
import com.zhouwei.mzbanner.holder.MZHolderCreator;
import com.zhouwei.mzbanner.holder.MZViewHolder;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import okhttp3.MultipartBody;

public class MainActivity extends BaseActivity {


    private MZBannerView banner;
    private MyBannerPresenter myBannerPresenter;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        myBannerPresenter = new MyBannerPresenter(new MyBannerCall());
        myBannerPresenter.reqeust();
    }

    @Override
    protected void destoryData() {
        myBannerPresenter.unBind();
    }

    private class MyBannerCall implements DataCall<Result<List<MyBanner>>> {
        @Override
        public void success(Result<List<MyBanner>> data) {
            List<MyBanner> result = data.getResult();
            banner = findViewById(R.id.banner);
            // 设置数据
            banner.setPages(result, new MZHolderCreator<BannerViewHolder>() {
                @Override
                public BannerViewHolder createViewHolder() {
                    return new BannerViewHolder();
                }
            });

        }

        @Override
        public void fail(ApiException e) {

        }
    }


    public class BannerViewHolder implements MZViewHolder<MyBanner> {
        private ImageView mImageView;
        private TextView mTextView;

        @Override
        public View createView(Context context) {
            // 返回页面布局
            View view = LayoutInflater.from(context).inflate(R.layout.banner_iteam, null);
            mImageView = (ImageView) view.findViewById(R.id.banner_image);
            mTextView = view.findViewById(R.id.banner_text);
            return view;
        }

        @Override
        public void onBind(Context context, int i, MyBanner resultBean) {
//            Glide.with(context).load(resultBean.getImg_url()).into(mImageView);
            if (resultBean.getTitle() != null) {
                mTextView.setText(resultBean.getTitle());
            } else {
                mTextView.setText(resultBean.getInfor_title());
            }
            if (resultBean.getImg_url() != null) {
                Glide.with(context).load(resultBean.getImg_url()).into(mImageView);
            } else {
                Glide.with(context).load(resultBean.getMain_img_url()).into(mImageView);
            }

        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        banner.pause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        myBannerPresenter.unBind();
    }
}
