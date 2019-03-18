package com.hss.spring.day1.demo3;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SprinDemo3 {

    @Test
    /**
     * 静态工厂实例化
     *     <bean id="bean2" class="com.hss.spring.day1.demo3.Bean2Factory" factory-method="createBean2"/>
     */
    public void demo2(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        Bean2 bean2 = (Bean2) applicationContext.getBean("bean2");
        System.out.println(bean2);
    }

    @Test
    /**
     * 实例工厂实例化
     *
     * <bean id="bean3Factory" class="com.hss.spring.day1.demo3.Bean3Factory"></bean>
     *     <bean id="bean3" factory-bean="bean3Factory" factory-method="createBean3"></bean>
     */
    public void demo3(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        Bean3 bean3 = (Bean3) applicationContext.getBean("bean3");
        System.out.println(bean3);
    }
}
