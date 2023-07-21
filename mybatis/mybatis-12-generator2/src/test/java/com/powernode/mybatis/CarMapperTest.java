package com.powernode.mybatis;

import com.powernode.mybatis.mapper.CarMapper;
import com.powernode.mybatis.pojo.Car;
import com.powernode.mybatis.pojo.CarExample;
import com.powernode.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class CarMapperTest {

    @Test
    public void testSelectAll(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);

        //1.查询一个
        Car car1 = mapper.selectByPrimaryKey(22);
        System.out.println(car1);

        //2.查询所有,selectByExample 根据条件查询,条件为null查询全部
        List<Car> cars = mapper.selectByExample(null);
        cars.forEach(car -> System.out.println(car));
        System.out.println("________________________________________________________________");

        //3.根据条件查询
        CarExample carExample = new CarExample();
        CarExample.Criteria carExamplle = carExample.createCriteria().andBrandLike("福特野马");
        List<Car> cars1 = mapper.selectByExample(carExample);
        System.out.println(cars1);


        sqlSession.close();
    }
}
