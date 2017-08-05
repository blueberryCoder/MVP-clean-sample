package com.blueberry.star.entity;

/**
 * Created by Administrator on 8/3/2017.
 */
public class RestResponse<T> {
    private T data;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
