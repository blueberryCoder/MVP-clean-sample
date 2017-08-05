package com.blueberry.start.presentation.view;

import android.content.Context;

/**
 * Created by blueberry on 8/5/2017.
 */

public interface LoadDataView {

    void showLoading();

    void hideLoading();

    void showError(String msg);

    Context context();
}
