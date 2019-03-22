package com.hss.spring.day3.transaction.demo3;

import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED)
public class AccountServiceImpl implements AccountService {

    private AccountDao accountDao;

//    private TransactionTemplate transactionTemplate;

    @Override
    public void transfer(String from, String to, Double money) {

        accountDao.outMoney(from,money);
        int i= 1/0;
        accountDao.inMoney(to,money);

    }

    public AccountDao getAccountDao() {
        return accountDao;
    }

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

}
