package com.cskaoyan.mall.service;

import com.cskaoyan.mall.bean.User;

import java.util.HashMap;
import java.util.List;

/**
 * @author Created by altruist_cheng on 2021-08-07 21:34
 * @version 1.0
 */

public interface UserService {

    HashMap<Object, Object> queryAllUsers(Integer page, Integer limit, String sort,
                                          String order, String username, String mobile);

    HashMap<Object, Object> queryAllAddress(Integer page, Integer limit, String sort,
                                            String order, String name, Integer userId);
}
