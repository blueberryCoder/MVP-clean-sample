package com.blueberry.star.data.api;

import com.blueberry.star.data.model.BaseResp;
import com.blueberry.star.domain.model.Star;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by blueberry on 8/5/2017.
 */

public interface StarApi {

    @GET("star/list")
    Observable<BaseResp<List<Star>>> list();
}
