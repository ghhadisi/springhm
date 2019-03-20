package com.hss.spring.day2.cproxy;

import com.hss.spring.day2.bean.UserDAO;
import com.hss.spring.day2.bean.UserDAOImpl;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;


//观光代码=>cglib代理
public class UserDaoProxyFactory2 implements MethodInterceptor {


    public UserDAO getUserDaoProxy(){
        Enhancer enhancer = new Enhancer();//帮我们生成代理对象
        enhancer.setSuperclass(UserDAOImpl.class);//设置对谁进行代理

        enhancer.setCallback(this);//代理要做什么

        UserDAO userDAO = (UserDAO) enhancer.create();
        return userDAO;
    }


    @Override
    public Object intercept(Object prxoyobj, Method method, Object[] arg, MethodProxy methodProxy) throws Throwable {
//        //打开事务
//        System.out.println("打开事务!");
//        //调用原有方法
//        Object returnValue = methodProxy.invokeSuper(prxoyobj, arg);
//        //提交事务
//        System.out.println("提交事务!");
//
//        return returnValue;


        if("delete".equals(method.getName())){
            Object obj = methodProxy.invokeSuper(prxoyobj, arg);
            System.out.println("日志记录================");
            return obj;
        }
        return methodProxy.invokeSuper(prxoyobj, arg);
    }
}
