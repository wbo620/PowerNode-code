package com.powernode.bank.dao.impl;

import com.powernode.bank.dao.AccountDao;
import com.powernode.bank.pojo.Account;
import com.powernode.bank.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;


/**
 * @author hallen
 */
//public class AccountDaoImpl implements AccountDao {
//
//
//    public Account selectByActno(String actno) {
//        SqlSession sqlSession = SqlSessionUtil.openSession();
//        Account account = (Account) sqlSession.selectOne("com.powernode.bank.dao.AccountDao.selectByActno", actno);
//        return account;
//    }
//
//    public int updateByActno(Account account) {
//        SqlSession sqlSession = SqlSessionUtil.openSession();
//        int count = sqlSession.update("com.powernode.bank.dao.AccountDao.updateByActno", account);
//        return count;
//    }
//
//
//}
