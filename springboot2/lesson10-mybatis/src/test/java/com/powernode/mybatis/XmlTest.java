package com.powernode.mybatis;

import com.powernode.mybatis.mapper.XmlMapper;
import com.powernode.mybatis.pojo.Car;
import jakarta.annotation.Resource;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * User: hallen
 * Date: 2023/8/17
 * Time: 22:36
 */
@SpringBootTest
public class XmlTest {

    @Resource
    private XmlMapper xmlMapper;

    @org.junit.jupiter.api.Test
    void selectAll() {
        List<Car> cars = xmlMapper.selectAll();
        System.out.println(cars);
    }
}
