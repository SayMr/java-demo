package com.zyt.javademo; /**
 * Created by zhuyi on 2018/5/14.
 */

import lombok.extern.slf4j.Slf4j;
import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author zhuyintao
 * @date 2018-05-14
 */
@RunWith(SpringJUnit4ClassRunner.class)
@Slf4j
@Rollback(value = true)
@Transactional
@WebAppConfiguration
@ContextConfiguration
        (locations = {
                "classpath:application-context.xml",
                "classpath:springmvc-servlet.xml"})
public class BaseTest {

    @Value("${zookeeper.address}")
    private String zkHosts;

    public String getZkConnectStr() {
        return zkHosts;
    }

    @Test
    public void testJJ() throws Exception {
        log.info("BaseTest:{}", "BaseTest");
        Pattern p = Pattern.compile("^(([1-9]{1}\\d*)|([0]{1}))(\\.(\\d){0,2})?$");
        Matcher m = p.matcher("40000");
        System.out.println(m.matches());

        System.out.println(Double.parseDouble("400"));
        System.out.println(Double.parseDouble("400.0"));
        System.out.println(Double.parseDouble("400.00"));

        System.out.println(new Date());

        RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000, 3);
        CuratorFramework client = CuratorFrameworkFactory.newClient(zkHosts, retryPolicy);
        client.start();


        InterProcessMutex lock = new InterProcessMutex(client, "/dhsale/dhsale_test_lock");
        if (lock.acquire(30, TimeUnit.SECONDS)) {
            try {
                // do some work inside of the critical section here
            } finally {
                lock.release();
            }
        }
    }
}
