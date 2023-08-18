package com.powernode.mybatis;

import com.powernode.mybatis.mapper.ProviderMapper;
import com.powernode.mybatis.pojo.Car;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * User: hallen
 * Date: 2023/8/17
 * Time: 23:11
 */
@SpringBootTest
public class ProviderTest {
    @Resource
    private ProviderMapper providerMapper;

    @Test
    void findAll() {
        List<Car> cars = providerMapper.selectAll();
        System.out.println(cars);
    }

    @Test
    void findOne(){
        Car car = providerMapper.selectOne(30);
        System.out.println(car);
    }
}
