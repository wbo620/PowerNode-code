package com.powernode.mybatis.mapper;

import com.powernode.mybatis.pojo.Car;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * User: hallen
 * Date: 2023/8/17
 * Time: 22:34
 */

public interface XmlMapper {
    @Select("""
            select id,brand,produce_time,car_num,car_type,guide_price
            from t_car
            """)
    //使用xml文件中的映射
    @ResultMap("CarMap")
    List<Car> selectAll();
}
