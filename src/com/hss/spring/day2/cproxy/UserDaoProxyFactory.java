package com.hss.spring.day2.cproxy;

import com.hss.spring.day2.bean.UserDAO;
import com.hss.spring.day2.bean.UserDAOImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class UserDaoProxyFactory implements InvocationHandler {
    UserDAO userDAO;


    public UserDaoProxyFactory(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public UserDAO getUserDaoProxy(){
        return (UserDAO)Proxy.newProxyInstance(UserDaoProxyFactory.class.getClassLoader(), UserDAOImpl.class.getInterfaces(),this);
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//        if (method.equals("save")){
            System.out.println("打开事务!");
            Object invoke = method.invoke(userDAO, args);
            System.out.println("提交事务!");
//        }
        return invoke;
    }
}
