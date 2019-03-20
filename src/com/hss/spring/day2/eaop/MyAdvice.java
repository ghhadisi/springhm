package com.hss.spring.day2.eaop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

//通知类
@Aspect
public class MyAdvice {
    @Pointcut("execution(* com.hss.spring.day2.bean.*UserDAOImpl.*(..))")
    public void pc(){

    }
    public  void advice(){

        System.out.println("advice");
    }

    //前置通知
    //指定该方法是前置通知,并制定切入点
    @Before("MyAdvice.pc()")
    public  void before(){
        System.out.println("这是前置通知!!");

    }
//    @AfterReturning(value = "declareJoinPointExpression()", returning = "result") //这行里少了returning = "result"这个参数，加上就可以以了
    //后置通知
    @AfterReturning("execution(* com.hss.spring.day2.bean.*.*(..))")
    public  void afterReturning(){
        System.out.println("afterReturning");

    }

    //环绕通知
    @Around("execution(* com.hss.spring.day2.bean.*Impl.*(..))")
    public void around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("环绕执行前 2222");
        proceedingJoinPoint.proceed();
        System.out.println("环绕执行后 222");

    }

    @AfterThrowing(pointcut="execution(* com.hss.spring.day2.bean.*Impl.*(..))",throwing="e")
    public void afterException(Exception e){
        System.out.println("AfterThrowing = "+e.getMessage());
    }

    @Around("execution(* com.hss.spring.day2.bean.*.*(..))")
    public void finalMethod(){
        System.out.println("finalMethod 2222");

    }
}
