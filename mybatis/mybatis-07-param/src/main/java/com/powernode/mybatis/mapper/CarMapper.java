package com.powernode.mybatis.mapper;

import com.powernode.mybatis.pojo.Car;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface CarMapper {
    /**
     * 插入车辆信息
     * @param car
     * @return
     */
    int insert(Car car);

    /**
     * 根据id删除
     * @param id
     * @return
     */
    int deleteById(Long id);

    int updateById(Car  car);

    /**
     * 根据id删除信息
     * @param id
     * @return
     */

    Car selectById(Long id);

    /**
     * 查询全部信息
     * @return
     */
    List<Car> selectAll();

    /**
     * 插入车辆信息并返回自动生成的主键
     * @param car
     * @return
     */
    int insertCarUseGeneratedKey(Car car);

    /**
     * 给参数设置别名
     * @param id
     * @param carType
     * @return
     */

    Car selectCarByIdAndCarType(@Param("id") Long id, @Param("carType") String carType);

    /**
     * 通过mybatisp-config的配置,驼峰命名与表中的字段名的自动映射查询
     * @return
     */
    List<Car> selectAllUseUnderscoreToCamelCase();


    /**
     * 查询所有,返回list集合
     */
    List<Car> selectAlltoList();

    /**
     * 查询所有,返回list<map<>>集合
     */
    List<Map<String, Object>> selectAlltoListMap();


    /**
     * 返回一个大map集合 Map<Long,Map<>>集合
     * map集合的key是表中的主键值
     */
    @MapKey("id")//将查询结果的id作为大map的key
    Map<Long,Map<String,Object>> selectAlltoMapMap();


    /**
     * 通过id查询 返回Map集合
     * @return
     */
    Map<String, Object> selectByIdtoMap(Long id);

    /**
     * 查询所有的数据,使用resultMap标签进行结果的映射
     * @return
     */
    List<Car> selectAllResultMap();

}
