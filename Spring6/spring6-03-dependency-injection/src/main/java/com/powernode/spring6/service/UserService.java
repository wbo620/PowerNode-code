package com.powernode.spring6.service;

import com.powernode.spring6.dao.UserDao;
import com.powernode.spring6.dao.VipDao;

public class UserService {

    private UserDao userDao;

    private VipDao vipDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void setVVVVV(VipDao vipDao) {
        this.vipDao = vipDao;
    }

    public void  saveUser() {
        userDao.insert();
    }

    public void saveVip() {
        vipDao.insert();
    }
}
