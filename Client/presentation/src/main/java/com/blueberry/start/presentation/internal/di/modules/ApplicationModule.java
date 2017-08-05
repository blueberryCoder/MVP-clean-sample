package com.blueberry.start.presentation.internal.di.modules;

import android.content.Context;

import com.blueberry.star.data.executor.JobExecutor;
import com.blueberry.star.data.repository.StarRepositoryImpl;
import com.blueberry.star.domain.executor.PostExecutionThread;
import com.blueberry.star.domain.executor.ThreadExecutor;
import com.blueberry.star.domain.repository.StarRepository;
import com.blueberry.start.presentation.App;
import com.blueberry.start.presentation.executor.UIThread;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by blueberry on 8/4/2017.
 */

@Module
public class ApplicationModule {
    private final App application;

    public ApplicationModule(App app) {
        this.application = app;
    }

    @Singleton
    @Provides
    Context provideApplicationContext() {
        return this.application;
    }


    @Singleton
    @Provides
    StarRepository provideStarRepository(StarRepositoryImpl repository) {
        return repository;
    }

    @Singleton
    @Provides
    ThreadExecutor provideThreadExecutor(JobExecutor jobExecutor) {
        return jobExecutor;
    }

    @Singleton
    @Provides
    PostExecutionThread providePostExecutionThread(UIThread thread) {
        return thread;
    }
}
