package com.powernode.transation.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.mybatis.spring.annotation.MapperScan;

/**
 * User: hallen
 * Date: 2023/8/18
 * Time: 17:11
 */
@Mapper
public interface ActMapper {

    //查询余额
    @Select(value = "select balance from t_act where actno=#{actNo}")
    double getBalance(Integer actNo);

   //转出,余额减少
    @Update("update t_act set balance=#{money} where actno=#{actNo}")
    int rollOut(Integer actNo, double money);

    //转入,余额增加
    @Update("update t_act set balance=#{money} where actno=#{actNo}")
    int inTo(Integer actNo, double money);
}
