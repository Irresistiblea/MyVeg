package com.myveg.demo;

import com.myveg.demo.dao.UserDao;
import com.myveg.demo.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MyVegDemoApplicationTests {
    @Autowired
    private UserService userService;
    @Test
    void contextLoads() {
        System.out.println(userService.loginOrNot("m15872715936_1@163.com","123"));
    }

}
