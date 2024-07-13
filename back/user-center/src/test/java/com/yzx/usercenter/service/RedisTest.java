package com.yzx.usercenter.service;

import com.yzx.usercenter.model.domain.User;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

@SpringBootTest
public class RedisTest {

    @Resource
    private RedisTemplate redisTemplate;
    @Test
    void   test(){
        ValueOperations valueOperations = redisTemplate.opsForValue();
        //增
        valueOperations.set("yzxString","shuai");
        valueOperations.set("yzxInt",1);
        valueOperations.set("yzxDouble",2.0);
        User user = new User();
        user.setId(1L);
        user.setUsername("yzx");
        valueOperations.set("yzxUser",user);

        //查
        Object yzx = valueOperations.get("yzxString");
        valueOperations.get("yzxInt");
        valueOperations.get("yzxDouble");

    }
}
