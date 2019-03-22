package com.hss.spring.day3.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

@Aspect
public class MyAspect {


    @Pointcut(value = "execution(* com.hss.spring.day3.aop.OrderDao.find(..))")
    public void pointcut1(){

    }

    @Pointcut(value="execution(* com.hss.spring.day3.aop.OrderDao.save(..))")
    private void pointcut2(){}
    @Pointcut(value="execution(* com.hss.spring.day3.aop.OrderDao.update(..))")
    private void pointcut3(){}
    @Pointcut(value="execution(* com.hss.spring.day3.aop.OrderDao.delete(..))")
    private void pointcut4(){}


    @Before(value = "MyAspect.pointcut1()")
    public void before(){
        System.out.println("前置增强===========");
    }
    // 后置通知:
//    @AfterReturning(value="MyAspect.pointcut4()",returning="result")
    public void afterReturning(Object result){
        System.out.println("后置增强==========="+result);
    }

    // 环绕通知:
//    @Around(value="MyAspect.pointcut3()")
    public Object arounwd(ProceedingJoinPoint joinPoint) throws Throwable{
        System.out.println("环绕前增强==========");
        Object obj  = joinPoint.proceed();
        System.out.println("环绕后增强==========");
        return obj;
    }

    // 异常抛出通知:
//    @AfterThrowing(value="MyAspect.pointcut1()",throwing="e")
    public void afterThrowing(Throwable e){
        System.out.println("异常抛出增强========="+e.getMessage());
    }

    // 最终通知
//    @After(value="MyAspect.pointcut1()")
    public void after(){
        System.out.println("最终增强============");
    }
}
