package com.blueberry.star.domain.repository;

import com.blueberry.star.domain.model.Star;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by blueberry on 8/5/2017.
 */

public interface StarRepository {
    Observable<List<Star>> list();
}
