package com.powernode.bank.service.impl;

import com.powernode.bank.exceptions.MonenNotEnougException;
import com.powernode.bank.exceptions.TransferException;
import com.powernode.bank.dao.AccountDao;
import com.powernode.bank.pojo.Account;
import com.powernode.bank.service.AccountService;
import com.powernode.bank.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;

/**
 * @author hallen
 */
public class AccountServiceImpl implements AccountService {

    //private AccountDao accountDao = new AccountDaoImpl();

    //使用mybatis里的getMapper方法来实现dao里的接口

    //- 在mybatis当中，mybatis提供了相关的机制。也可以动态为我们生成dao接口的实现类。（代理类：dao接口的代理）
    //- mybatis当中实际上采用了代理模式。在内存中生成dao接口的代理类，然后创建代理类的实例.
    //- 使用mybatis的这种代理机制的前提：SqlMapper,xmL文件中namespace必须是dao接口的全限定名称，id必须是dao接口中的方法名。
    private AccountDao accountDao = SqlSessionUtil.openSession().getMapper(AccountDao.class);
  

    @Override
    public void transfer(String fromActno, String toActno, double money) throws MonenNotEnougException, TransferException {
        //添加事务控制代码
        SqlSession sqlSession = SqlSessionUtil.openSession();


        Account fromUser = accountDao.selectByActno(fromActno);
        //获取转出用户的余额,检验输入的金额是否有效
        if (fromUser.getBalance() < money || money < 0) {
            throw new MonenNotEnougException("余额不足");
        }
        //查询转出的账户的金额,并更新两个账户数据
        Account toAct = accountDao.selectByActno(toActno);
        toAct.setBalance(toAct.getBalance() + money);
        int count = accountDao.updateByActno(toAct);
        System.out.println("更新数据条数:" + count);
        Account fromAct = accountDao.selectByActno(fromActno);
        fromAct.setBalance(fromAct.getBalance() - money);

        //更新转账余额
        count += accountDao.updateByActno(fromAct);

        if (count != 2) {
            throw new TransferException("数据更新异常");
        }
        ////模拟异常
        //String s=null;
        //s.toString();

        //提交事物
        sqlSession.commit();
        //关闭事物
        SqlSessionUtil.close(sqlSession);
    }
}
