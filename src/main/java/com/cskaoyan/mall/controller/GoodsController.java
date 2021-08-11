package com.cskaoyan.mall.controller;

import com.cskaoyan.mall.bean.BaseRespVo;
import com.cskaoyan.mall.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author Created by altruist_cheng on 2021-08-11 15:46
 * @version 1.0
 */
@RestController
public class GoodsController {

    @Autowired
    GoodsService goodsService;

    @RequestMapping("admin/goods/list")
    public BaseRespVo getGoodsList(Integer page, Integer limit, String sort,
                                   String order, String goodsSn, String name) {
        BaseRespVo baseRespVo = new BaseRespVo<>();
        Map<String, Object> map = goodsService.queryAllGoods(page, limit, sort, order, goodsSn, name);
        baseRespVo.setData(map);
        baseRespVo.setErrmsg("成功");
        baseRespVo.setErrno(0);
        return baseRespVo;
    }
}
