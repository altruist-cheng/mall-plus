package com.cskaoyan.mall.service.impl;

import com.cskaoyan.mall.bean.*;
import com.cskaoyan.mall.mapper.*;
import com.cskaoyan.mall.service.AdminService;
import com.cskaoyan.mall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Created by altruist_cheng on 2021-08-10 9:59
 * @version 1.0
 */
@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    AdminMapper adminMapper;
    @Autowired
    UserMapper userMapper;
    @Autowired
    GoodsProductMapper goodsProductMapper;
    @Autowired
    GoodsMapper goodsMapper;
    @Autowired
    OrderMapper orderMapper;


    @Override
    public Map<String, Long> dashboard() {
        Map<String, Long> map = new HashMap<>();
        long userTotal = userMapper.countByExample(new UserExample());
        long goodsTotal = goodsMapper.countByExample(new GoodsExample());
        long productTotal = goodsProductMapper.countByExample(new GoodsProductExample());
        long orderTotal = orderMapper.countByExample(new OrderExample());
        map.put("userTotal", userTotal);
        map.put("goodsTotal", goodsTotal);
        map.put("productTotal", productTotal);
        map.put("orderTotal", orderTotal);
        return map;
    }
}
