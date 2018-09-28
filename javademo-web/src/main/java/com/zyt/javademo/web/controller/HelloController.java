package com.zyt.javademo.web.controller;

import com.zyt.javademo.api.context.Result;
import com.zyt.javademo.provider.bean.context.BaseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by zhuyintao.
 * Date: 2018/9/20
 */
@Slf4j
@RestController
@RequestMapping(value = "/demo")
public class HelloController {

    @RequestMapping(value = "/hello")
    public Result hello() {
        log.info("hello,world!!!");
        return BaseResult.success();
    }

    @RequestMapping(value = "/log")
    public Result log() {
        try {
            Integer x = null;
            ++x;
        } catch (Exception e) {
            log.error(""+e);
            log.error(e.toString());
            log.error(e.getMessage());
            log.error(null, e);
            log.error("", e);
            log.error("{}", e);
            log.error("{}", e.getMessage());
            log.error("Error reading configuration file: " + e);
            log.error("Error reading configuration file: " + e.getMessage());
            log.error("Error reading configuration file", e);
        }
        return BaseResult.success();
    }
}
