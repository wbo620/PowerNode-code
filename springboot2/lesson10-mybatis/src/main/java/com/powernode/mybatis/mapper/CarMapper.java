package com.powernode.mybatis.mapper;

import com.powernode.mybatis.pojo.Car;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * User: hallen
 * Date: 2023/8/17
 * Time: 20:24
 */
public interface CarMapper {
    //按id查询
    @Select("""
            select id,brand,produce_time,car_num,car_type,guide_price
            from t_car
            where id=#{userId}
            """)
    //查询结果ResultSet和pojo对象的属性映射
    //没有驼峰命名自动映射,可以写结果映射集
    @Results(id = "Resid", value = {
            @Result(id = true, column = "id", property = "id"),
            @Result(column = "brand", property = "brand"),
            @Result(column = "produce_time", property = "produceTime"),
            @Result(column = "car_num", property = "carNum"),
            @Result(column = "guide_price", property = "guidePrice"),
            @Result(column = "car_type", property = "carType")
    })
    Car selectById(@Param("userId") Integer id);

    @Select("""
            select id,brand,produce_time,car_num,car_type,guide_price
            from t_car
            """)
    //ResultMap,引用定义好的映射id
    @ResultMap("Resid")
    //使用xml文件中的映射
    //@ResultMap("CarMap")
    List<Car> selectAll();

    @Delete("""
            delete from t_car where id=#{userId}
            """)
    int delete(@Param("userId") Integer id);

    @Insert("""
            insert into t_car(car_num, brand, guide_price, produce_time, car_type) 
            values (#{carNum}, #{brand}, #{guidePrice}, #{produceTime}, #{carType})
            """)
    int insert(Car car);
    //int insert(String carNum, String brand, Double guidePrice, String produceTime, String carType);

    @Update("""
            update t_car
            set car_num=#{carNum}
            where id=#{userId}

            """)
    int update(@Param("userId") Integer id, @Param("carNum") String carName);

}
