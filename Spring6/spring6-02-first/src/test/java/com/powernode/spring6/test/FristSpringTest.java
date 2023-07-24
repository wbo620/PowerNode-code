package com.powernode.spring6.test;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.logging.log4j.core.impl.Log4jContextFactory;
import org.junit.Test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.text.SimpleDateFormat;
import java.util.Date;

public class FristSpringTest {

    @Test
    public void testLog4J(){
        Log log = LogFactory.getLog(FristSpringTest.class);
        log.info("测试信息");
    }
    @Test
    public void testSpringCodeTest() {

        /**
         * 第一步：获取Spring容器对象。
         * ApplicationContext翻译为：应用上下文。其实就是Spring容器。
         * ApplicationContext是一个接口.
         * pplicationContext接口下有很多实现类。其中有一个实现类叫做：ClassPathXmlApplicationContext
         * ClassPathXmlApplicationContext专f门从类路径当中加载spring配置文件的一个Spring.上下文对象。
         * 这行代码只要执行：就相当于启动了Spring容器，解析spring.XmL文件，并且实例化所有bean对象，放到spring容器当中.
         */

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml", "beans.xml", "xml/bean.xml");
        //第二步:根据bean的id在Spring容器中获取这个对象
        Object userBean = applicationContext.getBean("userBean");
        System.out.println(userBean);

        Object userDaoImpl = applicationContext.getBean("userDaoImpl");
        System.out.println(userDaoImpl);

        Object vipBean = applicationContext.getBean("vipBean");
        System.out.println(vipBean);

        Object userBean2 = applicationContext.getBean("userBean2");
        System.out.println(userBean2);
        //获取当前日期
        Date dataBean = (Date) applicationContext.getBean("dataBean");
        System.out.println(dataBean);
        //对日期进行格式化
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String data = sdf.format(dataBean);
        System.out.println(data);

        //第二个参数可以指定数据类型
        Date data2 = applicationContext.getBean("dataBean", Date.class);
        System.out.println(data2);


    }
}
