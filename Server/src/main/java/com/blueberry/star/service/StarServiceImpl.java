package com.blueberry.star.service;

import com.blueberry.star.entity.Star;
import com.blueberry.star.repository.StarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Administrator on 8/3/2017.
 */
@Component
public class StarServiceImpl implements StarService {

    @Autowired
    StarRepository starRepository;

    @Override
    public List<Star> list() {
        return starRepository.list();
    }
}
