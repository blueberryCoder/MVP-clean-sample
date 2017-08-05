package com.blueberry.start.presentation.view.fragment;

import android.support.v4.app.Fragment;

import com.blueberry.start.presentation.internal.di.HasComponent;

/**
 * Created by blueberry on 8/5/2017.
 */

public class BaseFragment extends Fragment {

    protected <C> C getComponent(Class<C> componentType) {
        return componentType.cast(((HasComponent<C>) getActivity()).getComponent());
    }
}
