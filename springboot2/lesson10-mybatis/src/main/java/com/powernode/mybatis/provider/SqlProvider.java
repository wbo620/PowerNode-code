package com.powernode.mybatis.provider;

/**
 * User: hallen
 * Date: 2023/8/17
 * Time: 23:05
 */

public class SqlProvider {

    public static String selectAllSql() {
        return " select id,brand,produce_time,car_num,car_type,guide_price from t_car";
    }

    public static String selectById(Integer id) {
        return  "select id,brand,produce_time,car_num,car_type,guide_price\n" +
        "            from t_car where id=#{id}";
    }
}
