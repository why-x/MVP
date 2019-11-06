package com.example.edz.mvp.core;


import com.example.edz.mvp.bean.MyBanner;
import com.example.edz.mvp.bean.Result;


import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface Interfacea {
    /**
     *
     * @return
     */
    @GET("v1/home/showBanner")
    Observable<Result<List<MyBanner>>> mybanner();


}
