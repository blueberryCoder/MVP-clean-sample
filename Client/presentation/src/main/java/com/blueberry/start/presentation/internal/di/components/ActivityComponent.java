package com.blueberry.start.presentation.internal.di.components;

import android.app.Activity;

import com.blueberry.start.presentation.internal.di.PreActivity;
import com.blueberry.start.presentation.internal.di.modules.ActivityModule;

import dagger.Component;

/**
 * Created by blueberry on 8/5/2017.
 */

@PreActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
interface ActivityComponent {

    // Exposed to sub-graphs
    Activity activity();
}
