package com.hss.spring.day1.demo1;

import com.hss.spring.bean.UserDAO;
import com.hss.spring.bean.UserDAOImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import java.applet.AppletContext;

public class SpringDemo1 {
    @Test
    /**
     * 传统方式的调用
     */
    public void demo1(){
        UserDAOImpl userDAO = new UserDAOImpl();
        userDAO.setName("王东");
        userDAO.save();
    }
    @Test
    /**
     * Spring的方式的调用 name
     */
    public void demo2(){
        // 创建Spring的工厂
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDAO userDAO = (UserDAO) context.getBean("userDao");
        userDAO.save();
    }

    @Test
    /**
     * 加载磁盘上的配置文件
     */
    public void demo3(){
        ApplicationContext applicationContext = new FileSystemXmlApplicationContext("file:/home/acerdeepin/IdeaProjects/springhm/src/applicationContext.xml");
        UserDAO userDAO = (UserDAO) applicationContext.getBean("userDao");
        userDAO.save();
    }

    @Test
    /**
     * Spring的方式的调用  id
     *
     * id		:使用了约束中的唯一约束。里面不能出现特殊字符的。
     * name	:没有使用约束中的唯一约束（理论上可以出现重复的，但是实际开发不能出现的）。里面可以出现特殊字符。
     */
    public void demo4(){
        // 创建Spring的工厂
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDAO userDAO = (UserDAO) applicationContext.getBean("userDao1");
        userDAO.save();
    }
}
