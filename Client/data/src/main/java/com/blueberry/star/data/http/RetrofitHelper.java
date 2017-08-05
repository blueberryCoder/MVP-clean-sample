package com.blueberry.star.data.http;

import android.util.Log;

import javax.inject.Inject;
import javax.inject.Singleton;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by blueberry on 8/5/2017.
 */

@Singleton
public class RetrofitHelper {
    private static final String TAG = "RetrofitHelper";

    private Retrofit mRetrofit;

    @Inject
    RetrofitHelper() {
        Log.i(TAG, "RetrofitHelper: ");
        this.mRetrofit = new Retrofit.Builder()
                .baseUrl(Config.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    public Retrofit getRetrofit() {
        return this.mRetrofit;
    }


}
