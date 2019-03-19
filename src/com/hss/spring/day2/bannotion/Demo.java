package com.hss.spring.day2.bannotion;

import com.hss.spring.day2.bean.UserDAO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 *  * @Value :用于注入普通类型.
 *  * @Autowired :自动装配:
 *  * * 默认按类型进行装配.
 *  * * 按名称注入:
 *  * * @Qualifier:强制使用名称注入.
 *  * @Resource 相当于:
 *  * * @Autowired 和@Qualifier 一起使用.
 *
 */
//帮我们创建容器
@RunWith(SpringJUnit4ClassRunner.class)
//指定创建容器时使用哪个配置文件
@ContextConfiguration("classpath:com/hss/spring/day2/contextDay2.xml")
public class Demo {

    @Autowired
    @Qualifier(value = "userDao")
  private UserDAO user;

    @Resource(name = "userDao")
    private UserDAO user2;


//    @Value( "userDao")
//    private UserDAO user3;

    @Test
    public void fun1(){
        user.save();
        System.out.println(user);
    }

    @Test
    public void fun2(){
        user2.save();
        System.out.println(user2);
    }


    //: Error creating bean with name
//    @Test
//    public void fun3(){
//        user3.save();
//        System.out.println(user3);
//    }
}
