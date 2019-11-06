package com.example.edz.mvp.presenter;

import com.example.edz.mvp.core.Interfacea;
import com.example.edz.mvp.utils.DataCall;
import com.example.edz.mvp.utils.NetWorkManager;

import io.reactivex.Observable;

/**
 * 添加收藏
 */
public class MyBannerPresenter extends BasePresenter {
    public MyBannerPresenter(DataCall dataCall) {
        super(dataCall);
    }

    @Override
    protected Observable observable(Object... args) {
        Interfacea interfacea = NetWorkManager.getInstance().create(Interfacea.class);
        return interfacea.mybanner();
    }
}
