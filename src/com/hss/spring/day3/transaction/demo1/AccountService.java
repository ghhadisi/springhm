package com.hss.spring.day3.transaction.demo1;
/**
 * 转账的业务层的接口
 * @author jt
 *
 */
public interface AccountService {

	public void transfer(String from, String to, Double money);
	
}
