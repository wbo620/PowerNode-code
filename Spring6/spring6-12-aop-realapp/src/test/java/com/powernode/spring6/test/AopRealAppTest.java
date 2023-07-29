package com.powernode.spring6.test;

import com.powernode.spring6.biz.UserService;
import com.powernode.spring6.biz.VipService;
import com.powernode.spring6.service.AccountService;
import com.powernode.spring6.service.OrderService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AopRealAppTest {
    @Test
    public void testSecurityLog(){
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("spring.xml");
        UserService userService = applicationContext.getBean("userService", UserService.class);
        userService.saveUser();
        userService.deleteUser();
        userService.modifyUser();
        userService.getUser();

        VipService vipUser = applicationContext.getBean("vipService", VipService.class);
        vipUser.deleteVip();
        vipUser.getVip();
        vipUser.saveVip();
        vipUser.modifyVip();

    }

    @Test
    public void testTransaction(){
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("spring.xml");
        OrderService orderService = applicationContext.getBean("orderService", OrderService.class);
        orderService.generate();
        orderService.cancel();
        AccountService accountService = applicationContext.getBean("accountService", AccountService.class);
        accountService.transfer();
        accountService.withdraw();
    }

}
