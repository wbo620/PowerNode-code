package com.powernode.mybatis.PageTest;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.powernode.mybatis.mapper.CarMapper;
import com.powernode.mybatis.pojo.Car;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.util.List;

public class testPageHelper {
    @Test
    public void testPageHelper() throws Exception{
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));
        SqlSession sqlSession = sqlSessionFactory.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);

        // 开启分页
        PageHelper.startPage(2, 2);

        // 执行查询语句
        List<Car> cars = mapper.selectAll();

        // 获取分页信息对象
        PageInfo<Car> pageInfo = new PageInfo<>(cars, 5);

        System.out.println(pageInfo);
    }
}
