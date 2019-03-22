package com.hss.spring.day3.transaction.demo2;

import com.hss.spring.day3.transaction.demo2.AccountDao;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

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
