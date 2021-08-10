package com.cskaoyan.mall.bean;

import lombok.Data;

/**
 * @author Created by altruist_cheng on 2021-08-07 16:25
 * @version 1.0
 */
@Data
public class BaseRespVo<T> {

    /*
    *   errno : 0
        data : 859062cc-d49d-4730-b561-c2ff944023de
        errmsg : 成功
    * */

    private T data;
    private String errmsg;
    private Integer errno;
}
