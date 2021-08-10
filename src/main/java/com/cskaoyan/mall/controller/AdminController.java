package com.cskaoyan.mall.controller;

import com.cskaoyan.mall.bean.BaseRespVo;
import com.cskaoyan.mall.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author Created by altruist_cheng on 2021-08-07 22:28
 * @version 1.0
 */
@RestController
public class AdminController {

    @Autowired
    AdminService adminService;

    //首页
    @RequestMapping("admin/dashboard")
    public BaseRespVo dashBoard() {
        BaseRespVo<Object> baseRespVo = new BaseRespVo<>();
        Map<String, Long> dashboard = adminService.dashboard();
        baseRespVo.setErrno(0);
        baseRespVo.setData(dashboard);
        baseRespVo.setErrmsg("成功");
        return baseRespVo;
    }
}
