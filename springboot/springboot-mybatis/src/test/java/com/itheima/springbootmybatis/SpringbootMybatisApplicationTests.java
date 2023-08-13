package com.itheima.springbootmybatis;

import com.itheima.springbootmybatis.mapper.UserMapper;
import com.itheima.springbootmybatis.mapper.UserXmlMapper;
import com.itheima.springbootmybatis.pojo.User;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
class SpringbootMybatisApplicationTests {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserXmlMapper userXmlMapper;

    @Test
    public void testSelectAll(){
        List<User> userList = userMapper.selectAll();
        System.out.println(userList);
    }

    @Test
    public void testXmlSelectAll(){
        List<User> users = userXmlMapper.selectAll();
        System.out.println(users);
    }

}
