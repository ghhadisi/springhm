package com.hss.spring.day2.aanotion;

import com.hss.spring.day2.bean.UserDAO;
import com.hss.spring.day2.bean.UserDAOImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Demo {

    @Test
    public void fun1(){
        ApplicationContext context = new ClassPathXmlApplicationContext("com/hss/spring/day2/contextDay2.xml");//classpath://
        UserDAO userDAO = (UserDAO) context.getBean("userDao");

        UserDAO userDAO2 = (UserDAO) context.getBean("userDao");
        System.out.println(userDAO ==userDAO2);
        userDAO.save();
    }

    @Test
    public void fun2(){
        ApplicationContext context = new ClassPathXmlApplicationContext("com/hss/spring/day2/contextDay2.xml");//classpath://
        UserDAO userDAO = new UserDAOImpl();
                userDAO.save();
    }

}
