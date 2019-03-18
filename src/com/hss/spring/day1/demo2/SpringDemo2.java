package com.hss.spring.day1.demo2;

import com.hss.spring.bean.UserDAO;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringDemo2 {
    @Test
    /**
     * 生命周期的配置
     */
    public void demo1(){
        ClassPathXmlApplicationContext applicationContext= new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDAO userDAO = (UserDAO) applicationContext.getBean("userDao2");
        userDAO.save();
        applicationContext.close();

    }

    @Test
    /**
     * Bean的作用范围配置
     *
     *  scope			：Bean的作用范围
     *      * singleton		：默认的，Spring会采用单例模式创建这个对象。
     *      * prototype	：多例模式。（Struts2和Spring整合一定会用到）
     *      * request		：应用在web项目中，Spring创建这个类以后，将这个类存入到request范围中。
     *      * session		：应用在web项目中，Spring创建这个类以后，将这个类存入到session范围中。
     *      * globalsession	：应用在web项目中，必须在porlet环境下使用。但是如果没有这种环境，相对于session。
     */
    public void demo2(){
        ClassPathXmlApplicationContext applicationContext= new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDAO customerDAO1 = (UserDAO) applicationContext.getBean("userDao2");
        System.out.println(customerDAO1);
        UserDAO customerDAO2 = (UserDAO) applicationContext.getBean("userDao2");
        System.out.println(customerDAO2);
        System.out.println(customerDAO1==customerDAO2);
        applicationContext.close();

    }
}
