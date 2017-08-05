package com.blueberry.star.domain.interactor;

import com.blueberry.star.domain.executor.PostExecutionThread;
import com.blueberry.star.domain.executor.ThreadExecutor;

import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by blueberry on 8/5/2017.
 */

public abstract class UseCase<T, Params> {
    private final ThreadExecutor threadExecutor;
    private final PostExecutionThread postExecutionThread;
    private CompositeDisposable disposables;

    UseCase(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread) {
        this.threadExecutor = threadExecutor;
        this.postExecutionThread = postExecutionThread;
        this.disposables = new CompositeDisposable();
    }

    public void execute(DisposableObserver<T> observer, Params params) {
        final Observable<T> observable = this.buildUserCaseObservable(params)
                .subscribeOn(Schedulers.from(threadExecutor))
                .observeOn(postExecutionThread.getScheduler());
        addDisposable(observer, observable);
    }

    abstract Observable<T> buildUserCaseObservable(Params params);

    public void dispose() {
        if (!disposables.isDisposed()) {
            disposables.dispose();
        }
    }


    private void addDisposable(DisposableObserver<T> observer, Observable<T> observable) {
        this.disposables.add(observable.subscribeWith(observer));
    }
}

