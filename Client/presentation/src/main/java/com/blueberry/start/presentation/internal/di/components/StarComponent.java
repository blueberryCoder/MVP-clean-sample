package com.blueberry.start.presentation.internal.di.components;

import com.blueberry.start.presentation.internal.di.PreActivity;
import com.blueberry.start.presentation.internal.di.modules.ActivityModule;
import com.blueberry.start.presentation.internal.di.modules.StarModule;
import com.blueberry.start.presentation.view.fragment.StarListFragment;

import dagger.Component;

/**
 * Created by blueberry on 8/5/2017.
 */

@PreActivity
@Component(dependencies = ApplicationComponent.class, modules = {ActivityModule.class, StarModule.class})
public interface StarComponent extends ActivityComponent {
    void inject(StarListFragment fragment);
}
