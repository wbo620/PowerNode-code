package com.powernode.mybatis;

import com.powernode.mybatis.mapper.CarMapper;
import com.powernode.mybatis.pojo.Car;
import com.powernode.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;
import java.util.Map;

public class CarMapperTest {
    @Test
    public void testSelectAllResultMap(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        List<Car> cars = mapper.selectAllResultMap();
       cars.forEach(car -> System.out.println(car));
        sqlSession.close();
    }

    @Test
    public void testSelectAlltoMap() {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        Map<String, Object> map = mapper.selectByIdtoMap(21L);
        System.out.println(map);
        sqlSession.close();
    }
    @Test
    public void testSelectAlltoMapMap() {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        Map<Long, Map<String, Object>> cars = mapper.selectAlltoMapMap();
        System.out.println(cars);


        sqlSession.close();
    }
    @Test
    public void testSelectAlltoListMap() {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        List<Map<String, Object>> maps = mapper.selectAlltoListMap();
        System.out.println(maps);
        sqlSession.close();
    }
    @Test
    public void testSelectAlltoList(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        List<Car> cars = mapper.selectAlltoList();
        System.out.println(cars);
        sqlSession.close();
    }

    /**
     * 通过mybatisp-config的配置,驼峰命名与表中的字段名的自动映射查询
     */
    @Test
    public void testSelectAllUseUnderscoreToCamelCase(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        List<Car> cars = mapper.selectAllUseUnderscoreToCamelCase();
       cars.forEach(car -> System.out.println(car));
        sqlSession.close();
    }
    /**
     * 给参数起别名的方式
     */
    @Test
    public void testSelectCarByIdAndCarType(){

        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);

        Car car = mapper.selectCarByIdAndCarType(26L, "电动车");
        System.out.println(car);
        sqlSession.close();

    }
    @Test
    public void testInsert() {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        //面向接口获取接口的代理对象
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        int count = mapper.insert(new Car(null, "113", "长安福特", 100.00, "2019-10-3", "电动车"));
        System.out.println(count);
        sqlSession.commit();
        SqlSessionUtil.close(sqlSession);
    }

    @Test
    public void testDelectAll() {

        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        List<Car> cars = mapper.selectAll();
        cars.forEach(car -> System.out.println(car));

    }

    @Test
    public void testSelectById() {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        Car car = mapper.selectById(23L);
        System.out.println(car);
        sqlSession.close();

    }

    @Test
    public void testDeleteById() {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        int count = mapper.deleteById(24L);
        System.out.println(count);
        sqlSession.commit();

        SqlSessionUtil.close(sqlSession);
    }

    @Test
    public void testUpdateById() {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        int count = mapper.updateById(new Car(23L, "100", "福特野马", 23.0, "2018-10-9", "燃油车"));

        if (count == 1) {
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }
        System.out.println(count);

        SqlSessionUtil.close(sqlSession);
    }
}


