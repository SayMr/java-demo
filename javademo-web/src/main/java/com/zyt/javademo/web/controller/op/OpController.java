package com.zyt.javademo.web.controller.op;

import com.zyt.javademo.api.context.Result;
import com.zyt.javademo.provider.bean.context.BaseResult;
import com.zyt.javademo.provider.common.ShardedRedisUtil;
import com.zyt.javademo.provider.dao.DbConnectionCheck;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhuyintao.
 * Date: 2018/9/26
 */
@RestController
public class OpController {
    @Autowired
    private DbConnectionCheck dbConnectionCheck;

    @RequestMapping(value = "/health_check")
    public Result healthCheck() {

        Map map = new HashMap();
        try {
            Integer one = dbConnectionCheck.testConnection();
            if (one == 1) {
                map.put("mysql", 0);
            } else {
                map.put("mysql", 1);
            }

        } catch (Exception e) {
            map.put("mysql", 1);
        }
        try {
            ShardedRedisUtil redisUtil = ShardedRedisUtil.getInstance();
            redisUtil.set("demo_tanhuo_test", "test");
            String redisTestStr = redisUtil.get("demo_tanhuo_test");
            if (StringUtils.isNotEmpty(redisTestStr) && "test".equals(redisTestStr)) {
                map.put("redis", 0);
            } else {
                map.put("redis", 1);
            }
        } catch (Exception e) {
            map.put("redis", 1);
        }

        return BaseResult.success(map);
    }
}
