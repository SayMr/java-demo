package com.zyt.javademo.controller;

/**
 * Created by zhuyi on 2018/5/15.
 */

import com.zyt.javademo.BaseTest;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

public class BaseControllerTest extends BaseTest {
    protected MockMvc mockMvc;
    protected MockHttpSession session;

    @Autowired
    protected WebApplicationContext wac;
    @Before
    public void setup() throws Exception {
        this.mockMvc = webAppContextSetup(this.wac).build();
    }

    @Test
    public void testHello() throws Exception {
        mockMvc.perform(post("/test/hello")
                .param("ts", String.valueOf(System.currentTimeMillis()))
                .param("tag", "1")
                ).andExpect(status().isOk());
    }
}
