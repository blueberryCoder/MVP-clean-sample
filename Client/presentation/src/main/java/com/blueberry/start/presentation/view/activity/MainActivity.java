package com.blueberry.start.presentation.view.activity;

import android.os.Bundle;

import com.blueberry.start.R;
import com.blueberry.start.presentation.internal.di.HasComponent;
import com.blueberry.start.presentation.internal.di.components.DaggerStarComponent;
import com.blueberry.start.presentation.internal.di.components.StarComponent;
import com.blueberry.start.presentation.view.fragment.StarListFragment;

public class MainActivity extends BaseActivity implements HasComponent<StarComponent> {

    private StarComponent mUserComponent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.initializeInjector();
        getSupportFragmentManager()
                .beginTransaction()
                .add(android.R.id.content, StarListFragment.newInstance())
                .commitAllowingStateLoss();
    }


    private void initializeInjector() {
        this.mUserComponent = DaggerStarComponent.builder()
                .applicationComponent(getApplicationComponent())
                .activityModule(getActivityModule())
                .build();
    }

    @Override
    public StarComponent getComponent() {
        return this.mUserComponent;
    }
}
