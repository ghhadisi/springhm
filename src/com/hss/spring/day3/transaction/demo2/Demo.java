package com.hss.spring.day3.transaction.demo2;

import com.hss.spring.day3.transaction.demo1.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:com/hss/spring/day3/transaction/demo2/context.xml")
public class Demo {

    @Resource(name = "accountService")
    private AccountService accountService;


    @Test
    public void fun1(){
        accountService.transfer("aaa","bbb",1000d);
    }
}
