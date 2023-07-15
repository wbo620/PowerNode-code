package com.powernode.bank.mybatis;

import com.powernode.bank.mybatis.pojo.Car;
import com.powernode.bank.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;


public class CarMapperTest {
    @Test
    public void testInsertByPojo() {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        Car car = new Car(null, "1002", "比亚迪", 20.1, "2001-1-1", "电动");
        sqlSession.insert("insertCar", car);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testInsertCar() {

        SqlSession sqlSession = SqlSessionUtil.openSession();
        HashMap<String, Object> map = new HashMap<>();
        map.put("carNum", "1111");
        map.put("brand", "拉法");
        map.put("guidePrice", "1999.0");
        map.put("produceTime", "2019-1-1");
        map.put("carType", "燃油车");

        int count = sqlSession.insert("insertCar", map);
        System.out.println(count);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testDeleteCarByCar_num() {
        SqlSession sqlSession = SqlSessionUtil.openSession();

        int count = sqlSession.delete("deleteCarBycar_num", 1101);
        System.out.println(count);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testUpdateCarByCar_num() {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        Car car=new Car(4L,"1001","凯美瑞",3.3,"1999-11-10","撚油车");
        int count = sqlSession.update("updateCarBycar_num", car);
        System.out.println(count);


        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testSelectCarByCar_num() {
        SqlSession sqlSession = SqlSessionUtil.openSession();

        Object car = sqlSession.selectOne("selectCarBycar_num", "1002");
        System.out.println(car);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testSelectAllCar(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        List<Car> cars = sqlSession.selectList("selectAllCar");
       cars.forEach(car-> System.out.println(car));
        sqlSession.commit();
        sqlSession.close();
    }
}
