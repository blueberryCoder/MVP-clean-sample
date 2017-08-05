package com.blueberry.start.presentation.view;

import com.blueberry.star.domain.model.Star;

import java.util.List;

/**
 * Created by blueberry on 8/5/2017.
 */

public interface StarListView extends LoadDataView{

    void renderStarList(List<Star> models);
}
