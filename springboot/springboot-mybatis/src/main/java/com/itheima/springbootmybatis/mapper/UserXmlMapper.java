package com.itheima.springbootmybatis.mapper;

import com.itheima.springbootmybatis.pojo.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * User: hallen
 * Date: 2023/8/14
 * Time: 00:14
 */
@Mapper
public interface UserXmlMapper {
    public List<User> selectAll();
}
