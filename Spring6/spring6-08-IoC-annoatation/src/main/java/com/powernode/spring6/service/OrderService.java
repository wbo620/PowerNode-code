package com.powernode.spring6.service;

import com.powernode.spring6.dao.OrderDao;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("orderService")
public class OrderService {
    //@Autowired注解使用的时候，不需要指定任何属性，直接使用这个注解即可。
    //这个注解的作用是根据类byType进行自动装配。
    //@Autowired
    //private OrderDao orderDao;
    //如果想解决以上问题，只能根据名字进行装配。
    //@Autowired.@Qualifier.联合使用，可以根据名字进行装配。
    @Autowired
    @Qualifier("orderDaoImplForMysql")
    // @Qualifier("orderDaoImplForOrcle")
    private OrderDao orderDao;
    public void generate(){
        orderDao.insert();
    }
}
