package com.powernode.mybatis.mapper;

import com.powernode.mybatis.pojo.Car;

import java.util.List;

public interface CarMapper {
    int insert(Car car);
    int deleteById(Long id);

    int updateById(Car  car);

    Car selectById(Long id);
    List<Car> selectAll();

    int insertCarUseGeneratedKey(Car car);
}
