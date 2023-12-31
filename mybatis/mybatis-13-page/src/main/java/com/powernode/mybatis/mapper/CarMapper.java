package com.powernode.mybatis.mapper;

import com.powernode.mybatis.pojo.Car;
import com.powernode.mybatis.pojo.CarExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CarMapper {

    List<Car> selectAll();
    long countByExample(CarExample example);

    int deleteByExample(CarExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Car row);

    int insertSelective(Car row);

    List<Car> selectByExample(CarExample example);

    Car selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("row") Car row, @Param("example") CarExample example);

    int updateByExample(@Param("row") Car row, @Param("example") CarExample example);

    int updateByPrimaryKeySelective(Car row);

    int updateByPrimaryKey(Car row);
}