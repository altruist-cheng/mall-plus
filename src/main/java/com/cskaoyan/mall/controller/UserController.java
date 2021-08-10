package com.cskaoyan.mall.controller;

import com.cskaoyan.mall.bean.BaseRespVo;
import com.cskaoyan.mall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * @author Created by altruist_cheng on 2021-08-09 23:33
 * @version 1.0
 */
@RestController
public class UserController {

    @Autowired
    UserService userService;

    //会员管理
    @RequestMapping("admin/user/list")
    public BaseRespVo list(Integer page, Integer limit, String sort,
                           String order, String username, String mobile) {
        BaseRespVo<Object> baseRespVo = new BaseRespVo<>();
        //关键操作
        HashMap<Object, Object> map = userService.queryAllUsers(page, limit, sort, order, username, mobile);
        //返回状态
        baseRespVo.setData(map);
        baseRespVo.setErrmsg("成功");
        baseRespVo.setErrno(0);
        return baseRespVo;
    }

    //收货地址
    @RequestMapping("admin/address/list")
    public BaseRespVo addressList(Integer page, Integer limit, String sort,
                                  String order, String name, String userId) {
        BaseRespVo baseRespVo = new BaseRespVo();
        HashMap<Object, Object> map = userService.queryAllAddress(page, limit, sort, order, name, StringToInteger(baseRespVo, userId));
        baseRespVo.setErrno(0);
        baseRespVo.setData(map);
        baseRespVo.setErrmsg("成功");
        return baseRespVo;
    }

    private Integer StringToInteger(BaseRespVo baseRespVo, String id) {
        Integer idz = null;
        if (id != null && !"".equals(id)) {
            try {
                idz = Integer.parseInt(id);
            } catch (NumberFormatException e) {
                baseRespVo.setErrno(1);
                baseRespVo.setErrmsg("请输入正确格式");
            }
        }
        return idz;
    }

    //会员收藏

    //会员足迹

    //搜索历史

    //意见反馈

}
