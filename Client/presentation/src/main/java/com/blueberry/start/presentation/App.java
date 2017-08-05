package com.blueberry.start.presentation;

import android.app.Application;

import com.blueberry.start.presentation.internal.di.components.ApplicationComponent;
import com.blueberry.start.presentation.internal.di.components.DaggerApplicationComponent;
import com.blueberry.start.presentation.internal.di.modules.ApplicationModule;

/**
 * Created by blueberry on 8/4/2017.
 */

public class App extends Application {

    private ApplicationComponent mApplicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        this.initializeInjector();
    }

    private void initializeInjector() {
        this.mApplicationComponent =
                DaggerApplicationComponent
                        .builder()
                        .applicationModule(new ApplicationModule(this))
                        .build();
    }

    public ApplicationComponent getApplicationComponent() {
        return mApplicationComponent;
    }
}
