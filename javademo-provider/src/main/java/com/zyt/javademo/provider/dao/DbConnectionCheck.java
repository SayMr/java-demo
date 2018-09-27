package com.zyt.javademo.provider.dao;

/**
 * 检查数据库连接数据访问类
 * @author zhuyintao
 * @date 20180906
 */
public interface DbConnectionCheck {

    /**
     * 检测数据库连接
     * @return
     */
    int testConnection();

}
