package com.powernode.mybais.test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;

public class MybatisIntroduction {
    public static void main(String[] args) {
        SqlSession sqlSession = null;
        try {
            //获取sqlSessionFactoryBuilder对象
            SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
            //获取sqlSessionFactory对象
            SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(Resources.getResourceAsStream("mybatis-config.xml"));
            //开启会话(底层开启事务)
            sqlSession = sqlSessionFactory.openSession();
            //绑定要执行的sql语句,执行sql语句,处理相关业务
            int count = sqlSession.insert("insertCar");
            //打印结果
            System.out.println(count);
            //提交事物
            sqlSession.commit();


        } catch (Exception e) {
            e.printStackTrace();
            //修改失败,回滚事务
            if (sqlSession == null) {
                sqlSession.rollback();
            }

        } finally {
            //关闭会话,释放资源
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }
}
