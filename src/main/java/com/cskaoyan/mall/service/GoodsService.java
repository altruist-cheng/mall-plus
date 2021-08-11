package com.cskaoyan.mall.service;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Created by altruist_cheng on 2021-08-11 15:51
 * @version 1.0
 */
public interface GoodsService {

    Map<String, Object> queryAllGoods(Integer page, Integer limit, String sort,
                                      String order, String goodsSn, String name);
}
