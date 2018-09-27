package com.zyt.javademo.web.controller;

import com.zyt.javademo.api.context.Result;
import com.zyt.javademo.provider.bean.context.BaseResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by zhuyintao.
 * Date: 2018/9/20
 */
@RestController
@RequestMapping(value = "/demo")
public class HelloController {

    @RequestMapping(value = "/hello")
    public Result hello() {
        return BaseResult.success();
    }
}
