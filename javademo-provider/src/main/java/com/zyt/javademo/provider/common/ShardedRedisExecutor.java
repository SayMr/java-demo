package com.zyt.javademo.provider.common;

import redis.clients.jedis.ShardedJedis;

/**
 * Created by zhuyintao.
 * Date: 2018/9/27
 */
public interface ShardedRedisExecutor<T> {
    T execute(ShardedJedis jedis);
}
