package com.yzx.usercenter.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yzx.usercenter.model.domain.User;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.redisson.api.RList;
import org.redisson.api.RLock;
import org.redisson.api.RMap;
import org.redisson.api.RedissonClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.ValueOperations;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@SpringBootTest
public class RedissonTest {

    @Resource
    private RedissonClient redissonClient;
    @Test
    void test() {

        //redisson list
        RList<Object> rList = redissonClient.getList("test-list");
        rList.add("yzx");
        System.out.printf("rlist" + rList.get(0));
        rList.remove(0);

        //Map
        Map<String, Integer> map = new HashMap<>();
        map.put("yzx", 10);
        map.get("yzx");

        //redisson map
        RMap<Object, Object> map1 = redissonClient.getMap("test-map");
        map1.put("yzx", 10);
        map1.remove("yzx");
        System.out.printf("map" + map1.get("yzx"));
    }


    @Test
    void watchDogTest(){
            RLock lock = redissonClient.getLock("matching:precachejob:docache:lock");
            try {
                if (lock.tryLock(0,-1, TimeUnit.MILLISECONDS)) {
                    Thread.sleep(300000);
                    System.out.printf("getLock:" + Thread.currentThread().getId());
                }
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            } finally {
                //只能释放自己加的锁
                if(lock.isHeldByCurrentThread()){
                    System.out.printf("unLock:" + Thread.currentThread().getId());
                    lock.unlock();
            }
        }
    }
}
