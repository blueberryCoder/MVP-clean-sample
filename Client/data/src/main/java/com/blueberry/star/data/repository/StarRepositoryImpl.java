package com.blueberry.star.data.repository;

import com.blueberry.star.data.api.StarApi;
import com.blueberry.star.data.http.RetrofitHelper;
import com.blueberry.star.data.model.BaseResp;
import com.blueberry.star.domain.model.Star;
import com.blueberry.star.domain.repository.StarRepository;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;
import io.reactivex.functions.Function;

/**
 * Created by blueberry on 8/5/2017.
 */
@Singleton
public class StarRepositoryImpl implements StarRepository {

    private StarApi service;

    @Inject
    StarRepositoryImpl(RetrofitHelper helper) {
        service = helper.getRetrofit().create(StarApi.class);
    }

    @Override
    public Observable<List<Star>> list() {
        return service.list().map(new Function<BaseResp<List<Star>>, List<Star>>() {
            @Override
            public List<Star> apply(BaseResp<List<Star>> listBaseResp) throws Exception {
                return listBaseResp.getData();
            }
        });
    }

}
