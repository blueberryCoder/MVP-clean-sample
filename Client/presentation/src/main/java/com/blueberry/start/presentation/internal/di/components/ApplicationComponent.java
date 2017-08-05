package com.blueberry.start.presentation.internal.di.components;

import android.content.Context;

import com.blueberry.star.domain.executor.PostExecutionThread;
import com.blueberry.star.domain.executor.ThreadExecutor;
import com.blueberry.star.domain.repository.StarRepository;
import com.blueberry.start.presentation.internal.di.modules.ApplicationModule;
import com.blueberry.start.presentation.view.activity.BaseActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by blueberry on 8/4/2017.
 */
@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {
    void inject(BaseActivity baseActivity);

    // Exposed to sub-graphs.
    Context context();

    StarRepository starRepository();

    ThreadExecutor threadExecutor();

    PostExecutionThread postExecutionThread();
}
