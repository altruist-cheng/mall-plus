package com.cskaoyan.mall.service.impl;

import com.cskaoyan.mall.bean.Goods;
import com.cskaoyan.mall.bean.GoodsExample;
import com.cskaoyan.mall.mapper.GoodsMapper;
import com.cskaoyan.mall.service.GoodsService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Created by altruist_cheng on 2021-08-11 16:00
 * @version 1.0
 */
@Service
public class GoosServiceImpl implements GoodsService {

    @Autowired
    GoodsMapper goodsMapper;

    @Override
    public Map<String, Object> queryAllGoods(Integer page, Integer limit, String sort,
                                             String order, String goodsSn, String name) {
        //设置Example查询条件和排序方式
        GoodsExample goodsExample = new GoodsExample();
        GoodsExample.Criteria criteria = goodsExample.createCriteria();
        if (goodsSn != null && !goodsSn.isEmpty()) {
            criteria.andGoodsSnEqualTo(goodsSn);
        }
        if (name != null && !name.isEmpty()) {
            criteria.andNameLike("%" + name + "%");
        }
        criteria.andDeletedEqualTo(false);
        goodsExample.setOrderByClause(sort + " " + order);
        //开启分页
        PageHelper.startPage(page, limit);
        //进行查询
        List<Goods> goods = goodsMapper.selectByExampleWithBLOBs(goodsExample);
        //查询总数
        PageInfo<Goods> pageInfo = new PageInfo<>(goods);
        long total = pageInfo.getTotal();
        //生成返回数据
        HashMap<String, Object> map = new HashMap<>();
        map.put("items", goods);
        map.put("total", total);
        return map;
    }
}
