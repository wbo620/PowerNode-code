package com.powernode.jdbctemplate;

import com.powernode.jdbctemplate.pojo.Car;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.test.context.jdbc.Sql;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
class Lesson09JdbcTemplateApplicationTests {
    @Resource
    private JdbcTemplate jdbcTemplate;

    @Resource
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Test
    void count() {
        String sql = "select count(*) from t_car";
        Long count = jdbcTemplate.queryForObject(sql, Long.class);
        System.out.println(count);
    }


    @Test
    void selectOneById() {
        String sql = "select * from t_car where id=?";
        //BeanPropertyRowMapper将查询结果集，列名与属性名称匹配，名称完全匹配或驼峰
        Car car = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Car.class), 21);
        System.out.println(car.toString());
    }

    @Test
    void selectAll() {
        String sql = "select * from t_car";
        List<Map<String, Object>> listmap = jdbcTemplate.queryForList(sql);
        for (Map<String, Object> maps : listmap) {
            maps.forEach((name, value) ->
                    System.out.println(name + " = " + value));
            System.out.println("================================================================");
        }
    }

    @Test
    void UpdateById() {
        String sql = "update t_car set car_num = ? where id=? ";
        int count = jdbcTemplate.update(sql, 999, 29);
        System.out.println(count);
    }

    /**
     * 命名参数的方式
     */
    @Test
    void UpdateById2() {
        String sql = "update t_car set car_num =:num where id=:id ";
        Map<String, Object> map = new HashMap<>();
        map.put("num", 888);
        map.put("id", 29);
        int count = namedParameterJdbcTemplate.update(sql, map);
        System.out.println(count);
    }

    @Test
    void deleteById() {
        String sql = "delete from t_car where id=?";
        int count = jdbcTemplate.update(sql, 26);
        System.out.println(count);

    }

    @Test
    void insert() {
        String sql = "insert into t_car(car_num,brand ,guide_price,produce_time,car_type) values(?,?,?,?,?)";
        int count = jdbcTemplate.update(sql, "1234", "奥迪", 30.00, "2020-9-8", "电动");
        System.out.println(count);
    }
}
