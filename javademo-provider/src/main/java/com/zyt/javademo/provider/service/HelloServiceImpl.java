package com.zyt.javademo.provider.service;

import com.zyt.javademo.api.service.HelloService;

/**
 * Created by zhuyintao.
 * Date: 2018/9/23
 */
public class HelloServiceImpl implements HelloService {
    @Override
    public String hello() {
        return "hello dubbo";
    }
}
