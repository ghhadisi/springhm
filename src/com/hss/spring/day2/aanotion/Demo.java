package com.hss.spring.day2.aanotion;

import com.hss.spring.day2.bean.UserDAO;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Demo {

    @Test
    public void fun1(){
        ApplicationContext context = new ClassPathXmlApplicationContext("com/hss/spring/day2/contextDay2.xml");//classpath://
        UserDAO userDAO = (UserDAO) context.getBean("userDao");
        userDAO.save();
    }
}
