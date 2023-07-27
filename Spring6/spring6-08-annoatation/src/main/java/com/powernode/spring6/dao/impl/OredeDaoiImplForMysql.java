package com.powernode.spring6.dao.impl;

import com.powernode.spring6.dao.OrderDao;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository("orderDaoImplForMysql")
public class OredeDaoiImplForMysql implements OrderDao {
    private OrderDao orderDao;

    @Override
    public void insert() {
        System.out.println("Mysql正在保存数据");
    }
}
