package com.hss.spring.bean;
/**
 * 用户管理DAO层实现类
 * @author jt
 *
 */
public class UserDAOImpl implements UserDAO {
	private String name;

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void save() {
		System.out.println("UserDAOImpl执行了..."+name);
	}


	public void setup(){
		System.out.println("CustomerDAOImpl被初始化了...");
	}

	public void destroy(){
		System.out.println("CustomerDAOImpl被销毁了...");
	}
}
