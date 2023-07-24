package com.powernode.spring6.dao;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class UserDao {
    private static final Log LOG = LogFactory.getLog(UserDao.class);


    public void insert(){
        LOG.info("保存用户数据");
    }
}
