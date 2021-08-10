package com.cskaoyan.mall.controller;

import com.cskaoyan.mall.bean.BaseRespVo;
import com.cskaoyan.mall.bean.Region;
import com.cskaoyan.mall.service.MarketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Created by altruist_cheng on 2021-08-10 17:04
 * @version 1.0
 */
@RestController
public class MarketController {

    @Autowired
    MarketService marketService;

    @RequestMapping("admin/region/list")
    public BaseRespVo getRegionList() {
        BaseRespVo<Object> baseRespVo = new BaseRespVo<>();
        List<Region> regionList = marketService.getRegionList();
        baseRespVo.setData(regionList);
        baseRespVo.setErrmsg("成功");
        baseRespVo.setErrno(0);
        return baseRespVo;
    }
}
