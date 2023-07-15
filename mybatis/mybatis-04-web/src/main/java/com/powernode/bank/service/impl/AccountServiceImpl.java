package com.powernode.bank.service.impl;

import com.powernode.bank.exceptions.MonenNotEnougException;
import com.powernode.bank.exceptions.TransferException;
import com.powernode.bank.dao.AccountDao;
import com.powernode.bank.dao.impl.AccountDaoImpl;
import com.powernode.bank.pojo.Account;
import com.powernode.bank.service.AccountService;

public class AccountServiceImpl implements AccountService {

    private AccountDao accountDao = new AccountDaoImpl();

    @Override
    public void transfer(String fromActno, String toActno, double money) throws MonenNotEnougException, TransferException {
        Account fromUser = accountDao.selectByActno(fromActno);
        //获取转出用户的余额

        if (fromUser.getBalance() < money) {
            throw new MonenNotEnougException("余额不足");
        }

        Account toAct = accountDao.selectByActno(toActno);
        toAct.setBalance(toAct.getBalance() + money);
        int count = accountDao.updateByActno(toAct);
        System.out.println("更新数据条数:" + count);
        Account fromAct = accountDao.selectByActno(fromActno);
        fromAct.setBalance(fromAct.getBalance() - money);
        count += accountDao.updateByActno(fromAct);
        if (count != 2) {
            throw new TransferException("数据更新异常");
        }
    }
}
