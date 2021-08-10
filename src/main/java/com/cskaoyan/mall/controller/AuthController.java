package com.cskaoyan.mall.controller;

import com.cskaoyan.mall.bean.BaseRespVo;
import com.cskaoyan.mall.bean.LoginBean;
import com.cskaoyan.mall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Created by altruist_cheng on 2021-08-07 16:21
 * @version 1.0
 */
@RestController
@RequestMapping("admin/auth")
public class AuthController {

    @RequestMapping("login")
    public BaseRespVo login(@RequestBody LoginBean loginBean) {
        BaseRespVo<Object> objectBaseRespVo = new BaseRespVo<>();
        objectBaseRespVo.setData("207b5464-7924-46dd-86f4-788b033c9d00");
        objectBaseRespVo.setErrmsg("成功");
        objectBaseRespVo.setErrno(0);
        return objectBaseRespVo;
    }

    @RequestMapping("info")
    public String info() {
        String resp = "{\"errno\":0,\"data\":{\"roles\":[\"超级管理员\"],\"name\":\"admin123\",\"perms\":[\"*\"],\"avatar\":\"https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif\"},\"errmsg\":\"成功\"}";
        return resp;
    }

}
