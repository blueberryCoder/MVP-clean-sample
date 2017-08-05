package com.blueberry.start.presentation.presenter;

import android.util.Log;

import com.blueberry.star.domain.interactor.GetStarList;
import com.blueberry.star.domain.model.Star;
import com.blueberry.start.presentation.internal.di.PreActivity;
import com.blueberry.start.presentation.view.StarListView;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.observers.DisposableObserver;

/**
 * Created by blueberry on 8/5/2017.
 */

@PreActivity
public class UserListPresenter implements Presenter {
    private static final String TAG = "UserListPresenter";

    private final GetStarList mGetStarList;
    private StarListView mStarListView;

    @Inject
    public UserListPresenter(GetStarList getStarList) {
        this.mGetStarList = getStarList;
    }

    public void initialize() {
        this.mGetStarList.execute(new StarListObserver(), null);
    }

    public void setView(StarListView starListView) {
        this.mStarListView = starListView;
    }

    @Override
    public void resume() {

    }

    @Override
    public void pause() {
    }

    @Override
    public void destroy() {
        this.mGetStarList.dispose();
    }

    private class StarListObserver extends DisposableObserver<List<Star>> {
        @Override
        public void onNext(List<Star> value) {
            UserListPresenter.this.mStarListView.renderStarList(value);
            Log.i(TAG, "onNext: " + value.toString());
        }

        @Override
        public void onError(Throwable e) {
            UserListPresenter.this.mStarListView.showError("获取数据失败："+e.getMessage());
            e.printStackTrace();
        }

        @Override
        public void onComplete() {

        }
    }
}
