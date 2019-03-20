package com.hss.spring.day2.daop;

import org.aspectj.lang.ProceedingJoinPoint;

public class MyAdvice {
    public  void advice(){
        System.out.println("advice");
    }


    public  void before(){
        System.out.println("before");
    }
    public  void afterReturning(){
        System.out.println("afterReturning");

    }

    public void around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("环绕执行前");
        proceedingJoinPoint.proceed();
        System.out.println("环绕执行后");

    }

    public void afterException(Exception e){
        System.out.println(e.getMessage());
    }

    public void finalMethod(){
        System.out.println("finalMethod");

    }
}
