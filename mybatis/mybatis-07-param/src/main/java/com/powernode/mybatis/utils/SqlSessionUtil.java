package com.powernode.mybatis.utils;


import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;

/**
 * 自己封装 Mybatis工具类
 *
 * @author hallen
 * @version 1.0
 * @since 1.0
 */

public class SqlSessionUtil {
    //构造方法私有化,防止外部创建工具类的对象
    private SqlSessionUtil() {

    }

    private static SqlSessionFactory sqlSessionFactory;

    static {
        try {
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 获取会话对象
     *
     * @return 会话对象
     */

    //(全局的,服务器级别的,一个服务器创建一个足矣)
    //为什么把sqlsession绑定到threadlocal里,因为保证一个线程对应一个sqlsession对象
    private static ThreadLocal<SqlSession> local = new ThreadLocal<>();


    public static SqlSession openSession() {
        SqlSession sqlSession = local.get();
        if (sqlSession == null) {
            sqlSession = sqlSessionFactory.openSession();
            //将sqlsession绑定到当前的线程上
            local.set(sqlSession);
        }

        return sqlSession;
    }

    /**
     * 关闭sqlsession对象(在当前线程中移除sqlsession对象)
     * @param sqlSession
     */

    public static void close(SqlSession sqlSession) {
        if (sqlSession != null) {
            sqlSession.close();
            //移除sqlsession与当前线程的绑定关系
            local.remove();
        }
    }

}
