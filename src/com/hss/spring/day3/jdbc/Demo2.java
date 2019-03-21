package com.hss.spring.day3.jdbc;

import com.hss.spring.bean.Account;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:com/hss/spring/day3/jdbc/context.xml")
public class Demo2 {

    @Resource(name = "jdbctemplete")
    private JdbcTemplate template;
    @Test
    public void fun1(){
        template.update("insert  into  account values (null, ?, ?)","eee",10000);
    }



    @Test
    // 修改操作
    public void demo2(){
        template.update("update account set name = ? ,money = ? where id = ?", "何巨涛",2000d,6);
    }

    @Test
    // 删除操作
    public void demo3(){
        template.update("delete from account where id = ?", 6);
    }


    @Test
    // 查询操作：
    public void demo4(){
        String name = template.queryForObject("select name from account where id = ?", String.class, 2);
        System.out.println(name);
    }

    @Test
    // 统计查询
    public void demo5(){
        Long count = template.queryForObject("select count(*) from account", Long.class);
        System.out.println(count);
    }

    @Test
    // 封装到一个对象中
    public void demo6(){
        Account account = template.queryForObject("select * from account where id =?", new MyRowMapper(),3);
        System.out.println(account);
    }

    @Test
    // 查询多条记录
    public void demo7(){
//        List<Account> list = template.query("select * from account",new MyRowMapper());
//
//        for (Account account : list) {
//            System.out.println(account);
//        }

        List<String> list = template.queryForList("select name from account",String.class);

        for (String name : list){
            System.out.println(name);
        }
    }
    class MyRowMapper implements RowMapper<Account> {

        @Override
        public Account mapRow(ResultSet resultSet, int i) throws SQLException {
            Account account = new Account();
            account.setId(resultSet.getInt("id"));
            account.setName(resultSet.getString("name"));
            account.setMoney(resultSet.getDouble("money"));
            return account;
        }
    }
}
