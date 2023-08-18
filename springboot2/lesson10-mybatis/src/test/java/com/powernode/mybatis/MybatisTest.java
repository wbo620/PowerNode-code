package com.powernode.mybatis;

import com.powernode.mybatis.mapper.CarMapper;
import com.powernode.mybatis.pojo.Car;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class MybatisTest {

    @Resource
    private CarMapper carMapper;

    @Test
    void selectById() {
        Car car = carMapper.selectById(29);
        System.out.println(car);
    }

    @Test
    void findAll() {
        List<Car> cars = carMapper.selectAll();
        cars.forEach(car -> System.out.println(car));
    }

    @Test
    void add() {
        Car car=new Car(null,"1111", "大众", 99.9, "2010-11-2", "燃油车");
        int count = carMapper.insert(car);
        //int count = userMapper.insert("1111", "大众", 99.9, "2010-11-2", "燃油车");

        System.out.println(count);
    }

    @Test
    void dropById() {
        int count = carMapper.delete(31);
        System.out.println(count);
    }

    @Test
    void UpdateById() {
        int count = carMapper.update(30,"9999999");
        System.out.println(count);
    }
}
