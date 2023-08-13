package com.itheima.springbootmybatis.mapper;

import com.itheima.springbootmybatis.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * User: hallen
 * Date: 2023/8/13
 * Time: 23:55
 */
@Mapper
public interface UserMapper {
    @Select("select * from t_user")
    public List<User> selectAll();

}
