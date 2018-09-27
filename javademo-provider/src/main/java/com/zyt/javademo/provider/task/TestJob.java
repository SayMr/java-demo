package com.zyt.javademo.provider.task;

import com.dangdang.ddframe.job.api.ShardingContext;
import com.dangdang.ddframe.job.api.simple.SimpleJob;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * Created by zhuyintao.
 * Date: 2018/9/27
 */
@Slf4j
@Component
public class TestJob implements SimpleJob {
    @Override
    public void execute(ShardingContext shardingContext) {
        log.info("TestJob start ..., shardingItem:{}", shardingContext.getShardingItem());
        //TODO 业务逻辑
        log.info("TestJob end ...");
    }
}
