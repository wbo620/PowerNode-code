package com.powernode.bank.mybais.test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class MybatisIntroductionTest {
    public static void main(String[] args) throws IOException {
        //获取SqlSessionFactoryBuilder对象
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();

        //获取sqlSessionFactory对象
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");//默认在根路径查找资源
        SqlSessionFactory SqlSessionFactory = sqlSessionFactoryBuilder.build(is);

        //获取sqlSession对象
        SqlSession sqlSession = SqlSessionFactory.openSession();

        //执行sql语句
        int count = sqlSession.insert("insertCar");

        System.out.println("插入了数据条数:"+count);

        //手动提交
        sqlSession.commit();

    }
}
