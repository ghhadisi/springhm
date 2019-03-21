package com.hss.spring.day3.jdbc;

import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class Demo {
    // jdbc模板的使用类似于Dbutils.

    @Test
    public void fun1(){
        // 创建连接池:
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost/db2?useUnicode=true&amp;characterEncoding=UTF8");
        dataSource.setUsername("root");
        dataSource.setPassword("123456");
        // 创建jdbc模板
        JdbcTemplate template = new JdbcTemplate(dataSource);
        template.update("insert into account  values (null, ?, ?)", "张三", 10000);
    }
}
