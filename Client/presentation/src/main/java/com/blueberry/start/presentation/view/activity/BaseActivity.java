package com.blueberry.start.presentation.view.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.blueberry.start.presentation.App;
import com.blueberry.start.presentation.internal.di.components.ApplicationComponent;
import com.blueberry.start.presentation.internal.di.modules.ActivityModule;

/**
 * Created by blueberry on 8/4/2017.
 */

public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getApplicationComponent().inject(this);
    }

    public ApplicationComponent getApplicationComponent() {
        return ((App) this.getApplicationContext()).getApplicationComponent();
    }

    protected ActivityModule getActivityModule() {
        return new ActivityModule(this);
    }
}
