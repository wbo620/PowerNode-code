package com.powernode.service.impl;

/**
 * User: hallen
 * Date: 2023/8/8
 * Time: 21:56
 */


import com.powernode.mapper.UserMapper;
import com.powernode.pojo.User;
import com.powernode.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 */
@Service
public class UserServiceImpl implements UserService {

    //切记切记:一定会有数据访问层的对象

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> selectUserPage(String userName, String userSex, int startRow) {
        return userMapper.selectUserPage(userName, userSex, startRow);
    }

    @Override
    public int createUser(User user) {
        return userMapper.createUser(user);
    }

    @Override
    public int deleteUserById(String userId) {
        return userMapper.deleteUserById(userId);
    }

    @Override
    public int getRowCount(String userName, String userSex) {
        return userMapper.getRowCount(userName, userSex);
    }
}
