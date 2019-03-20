package com.hss.spring.day2.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 用户管理DAO层实现类
 * @author jt
 *Spring 中提供@Component 的三个衍生注解:(功能目前来讲是一致的)
	 * * @Controller :WEB 层
	 * * @Service :业务层
	 * * @Repository :持久层
 * 这三个注解是为了让标注类本身的用途清晰,Spring 在后续版本会对其增强
 *
 * Scope
 * singleton:单例
 * * prototype:多例
 *
 * @Value :用于注入普通类型.
 * @Autowired :自动装配:
 * * 默认按类型进行装配.
 * * 按名称注入:
 * * @Qualifier:强制使用名称注入.
 * @Resource 相当于:
 * * @Autowired 和@Qualifier 一起使用.
 *
 */
@Component(value = "userDao2")
//@Service(value = "userDao2")
//@Scope(value = "prototype")
public class UserDAOImpl implements UserDAO {
	@Value("lisi")
//	@Resource(name = "lisi")
	private String name;

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void save() {
//		int i = 1/0;
		System.out.println("UserDAOImpl执行了..."+name);
	}


	public void setup(){
		System.out.println("CustomerDAOImpl被初始化了...");
	}

	public void destroy(){
		System.out.println("CustomerDAOImpl被销毁了...");
	}



	@Override
	public void update() {
		System.out.println("UserDAOImpl执行了update..."+name);
	}

	@Override
	public void delete() {
		System.out.println("UserDAOImpl执行了delete..."+name);

	}

	@Override
	public void find() {
		System.out.println("UserDAOImpl执行了find..."+name);

	}

	public String getName() {
		return name;
	}
}
