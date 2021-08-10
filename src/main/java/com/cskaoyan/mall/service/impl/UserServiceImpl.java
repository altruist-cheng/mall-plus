package com.cskaoyan.mall.service.impl;

import com.cskaoyan.mall.bean.Address;
import com.cskaoyan.mall.bean.AddressExample;
import com.cskaoyan.mall.bean.User;
import com.cskaoyan.mall.bean.UserExample;
import com.cskaoyan.mall.mapper.AddressMapper;
import com.cskaoyan.mall.mapper.UserMapper;
import com.cskaoyan.mall.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * @author Created by altruist_cheng on 2021-08-07 21:35
 * @version 1.0
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    //查询会员条件
    public HashMap<Object, Object> queryAllUsers(Integer page, Integer limit, String sort,
                                                 String order, String username, String mobile) {
        UserExample userExample = new UserExample();
        //查找会员
        if (username != null && !username.isEmpty()) {
            userExample.createCriteria().andUsernameLike("%" + username + "%");
        }
        if (mobile != null && !mobile.isEmpty()) {
            userExample.createCriteria().andMobileEqualTo(mobile);
        }
        userExample.getOrderByClause(sort + "" +order);
        //分页
        PageHelper.startPage(page, limit);
        //查询
        List<User> users = userMapper.selectByExample(userExample);
        //统计总数
        PageInfo<User> userPageInfo = new PageInfo<>(users);
        long total = userPageInfo.getTotal();
        //返回数据
        HashMap<Object, Object> map = new HashMap<>();
        map.put("items", users);
        map.put("total", total);
        return map;
    }

    @Autowired
    AddressMapper addressMapper;

    @Override
    //收货地址
    public HashMap<Object, Object> queryAllAddress(Integer page, Integer limit, String sort,
                                                   String order, String name, Integer userId) {
        String orderBy = sort + " " + order; //""不加空格会报错Unknown column 'add_timedesc' in 'order clause'
        PageHelper.startPage(page, limit, orderBy);
        AddressExample addressExample = new AddressExample();
        if (name != null && !name.isEmpty()) {
            addressExample.createCriteria().andNameLike("%" + name + "%");
        }
        if (userId != null) {
            addressExample.createCriteria().andUserIdEqualTo(userId);
        }
        List<Address> addresses = addressMapper.selectByExample(addressExample);
        PageInfo<Address> addressPageInfo = new PageInfo<>(addresses);
        long total = addressPageInfo.getTotal();
        HashMap<Object, Object> map = new HashMap<>();
        map.put("items", addresses);
        map.put("total", total);
        return map;
    }

}
