package com.blueberry.star.controller;

import com.blueberry.star.entity.RestResponse;
import com.blueberry.star.entity.Star;
import com.blueberry.star.service.StarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Administrator on 8/3/2017.
 */
@RestController
@RequestMapping("/star")
public class StarController {

    @Autowired
    StarService starService;

    @RequestMapping(method = RequestMethod.GET, value = "/list")
    public RestResponse<List<Star>> getStartList() {
        RestResponse<List<Star>> listRestResponse = new RestResponse<List<Star>>();
        listRestResponse.setData(starService.list());
        return listRestResponse;
    }
}
