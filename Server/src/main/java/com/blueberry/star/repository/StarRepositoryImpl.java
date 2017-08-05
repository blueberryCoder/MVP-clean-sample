package com.blueberry.star.repository;

import com.blueberry.star.data.StarData;
import com.blueberry.star.entity.Star;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 8/3/2017.
 */
@Component
public class StarRepositoryImpl implements StarRepository {
    @Override
    public List<Star> list() {

        return StarData.stars;
    }
}
