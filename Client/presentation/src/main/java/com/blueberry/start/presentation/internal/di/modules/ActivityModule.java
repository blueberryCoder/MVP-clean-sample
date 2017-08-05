package com.blueberry.start.presentation.internal.di.modules;

import android.app.Activity;

import com.blueberry.start.presentation.internal.di.PreActivity;

import dagger.Module;
import dagger.Provides;

/**
 * Created by blueberry on 8/5/2017.
 */

@Module
public class ActivityModule {
    private Activity activity;

    public ActivityModule(Activity activity) {
        this.activity = activity;
    }

    @Provides
    @PreActivity
    Activity activity() {
        return this.activity;
    }
}
