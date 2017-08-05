package com.blueberry.star.data.model;

/**
 * Created by blueberry on 8/5/2017.
 */

public class BaseResp<T> {

    T data;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
