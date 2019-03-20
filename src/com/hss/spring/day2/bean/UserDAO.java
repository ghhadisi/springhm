package com.hss.spring.day2.bean;
/**
 * 用户管理DAO层接口
 * @author jt
 *
 */
public interface UserDAO {
	public void save();

    public void update();
    public void delete();
    public void find();
}
