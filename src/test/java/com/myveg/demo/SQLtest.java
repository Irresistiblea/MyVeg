package com.myveg.demo;

import com.myveg.demo.dao.UserDao;
import com.myveg.demo.dao.impl.UserDaoImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.*;

public class SQLtest {


    @Test
    public void test() throws IOException {
        String a="/toPage?url=/a.html";
        System.out.println(a.contains(".html"));
    }
}
