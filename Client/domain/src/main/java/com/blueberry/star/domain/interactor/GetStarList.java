package com.blueberry.star.domain.interactor;

import com.blueberry.star.domain.executor.PostExecutionThread;
import com.blueberry.star.domain.executor.ThreadExecutor;
import com.blueberry.star.domain.model.Star;
import com.blueberry.star.domain.repository.StarRepository;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * Created by blueberry on 8/5/2017.
 */

public class GetStarList extends UseCase<List<Star>, Void> {

    private StarRepository mStarRepository;

    @Inject
    GetStarList(StarRepository starRepository, ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread) {
        super(threadExecutor, postExecutionThread);
        this.mStarRepository = starRepository;
    }

    @Override
    Observable<List<Star>> buildUserCaseObservable(Void v) {
        return mStarRepository.list();
    }
}
