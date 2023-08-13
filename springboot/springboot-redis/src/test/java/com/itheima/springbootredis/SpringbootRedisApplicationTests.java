package com.itheima.springbootredis;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
class SpringbootRedisApplicationTests {
    @Autowired
    private RedisTemplate redisTemplate;

    //需要先启动redis
    // brew services start redis
    @Test
    public void testSet() {
        //存入数据
        redisTemplate.boundValueOps("name").set("张三");

    }

    @Test
    public void testGet() {
        //在缓存中取数据
        Object name = redisTemplate.boundValueOps("name").get();
        System.out.println(name);

    }

}
