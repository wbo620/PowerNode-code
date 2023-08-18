package com.powernode.mybatis.mapper;

import com.powernode.mybatis.pojo.Car;
import com.powernode.mybatis.provider.SqlProvider;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * User: hallen
 * Date: 2023/8/17
 * Time: 23:08
 */

public interface ProviderMapper {
    @Select("")
    @Results(id = "Resid", value = {
            @Result(id = true, column = "id", property = "id"),
            @Result(column = "brand", property = "brand"),
            @Result(column = "produce_time", property = "produceTime"),
            @Result(column = "car_num", property = "carNum"),
            @Result(column = "guide_price", property = "guidePrice"),
            @Result(column = "car_type", property = "carType")
    })
    Car carMapper();

    @ResultMap("Resid")
    @SelectProvider(type = SqlProvider.class, method = "selectAllSql")
    List<Car> selectAll();

    @ResultMap("Resid")
    @SelectProvider(type = SqlProvider.class, method = "selectById")
    Car selectOne(Integer id);

}
