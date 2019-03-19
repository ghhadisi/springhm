package com.hss.spring.day2.cproxy;

import com.hss.spring.day2.bean.UserDAO;
import com.hss.spring.day2.bean.UserDAOImpl;
import org.junit.Test;

public class demo1 {
    @Test
    //动态代理
    public void fun1(){
        UserDAO userDAO = new UserDAOImpl();
        UserDAO usProxy = new UserDaoProxyFactory(userDAO).getUserDaoProxy();
        usProxy.save();


        //代理对象与被代理对象实现了相同的接口
        //代理对象 与 被代理对象没有继承关系
        System.out.println(usProxy instanceof UserDAOImpl );//false
    }

    @Test
    //动态代理
    public void fun2(){
        UserDaoProxyFactory2 factory2 = new UserDaoProxyFactory2();
        UserDAO usProxy = factory2.getUserDaoProxy();

        usProxy.save();
//判断代理对象是否属于被代理对象类型
        //代理对象继承了被代理对象=>true
        System.out.println(usProxy instanceof UserDAOImpl );//true
    }

}
