package com.yzx.usercenter.service;

import com.yzx.usercenter.model.domain.User;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.StopWatch;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@SpringBootTest
public class InsertUsersTest {
    @Resource
    private UserService userService;

    @Test
    public void doConcurrencyInsertUsers(){
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        final int INSERT_NUM = 100000;
        int j = 0;
        List<CompletableFuture<Void>> futureList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            List<User> userList = new ArrayList<>();
            while (true){
                j++;
            User user = new User();
            user.setUsername("假用户");
            user.setUserAccount("fake");
            user.setAvatarUrl("https://8ig-event.oss-cn-beijing.aliyuncs.com/EEF76B0C8C1716F4649E217C184E9AB2.jpg");
            user.setGender(0);
            user.setUserPassword("12345678");
            user.setPhone("13211111111");
            user.setEmail("123@qq.com");
            user.setTags("[]");
            user.setUserStatus(0);
            user.setUserRole(0);
            user.setPlanetCode("11111");
            userService.save(user);
            if (j % 10000 == 0){
                break;
            }
        }
            CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
                System.out.printf("threadName:"+Thread.currentThread().getName());
                userService.saveBatch(userList, 10000);

            });
            futureList.add(future);

        }
        CompletableFuture.allOf(futureList.toArray(new CompletableFuture[]{})).join();
        stopWatch.stop();
        System.out.printf(String.valueOf(stopWatch.getTotalTimeMillis()));
    }
}
