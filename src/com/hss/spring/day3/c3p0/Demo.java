package com.hss.spring.day3.c3p0;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:com/hss/spring/day3/c3p0/context.xml")
public class Demo {
    @Resource(name = "jdbctemplete")
    private JdbcTemplate template;
    @Test
    public void fun1(){
        template.update("insert  into  account values (null, ?, ?)","cccc",10000);
    }
}
