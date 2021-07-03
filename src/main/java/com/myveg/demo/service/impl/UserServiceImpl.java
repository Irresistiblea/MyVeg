package com.myveg.demo.service.impl;

import com.myveg.demo.dao.UserDao;
import com.myveg.demo.dao.impl.UserDaoImpl;
import com.myveg.demo.domain.User;
import com.myveg.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Override
    public boolean loginOrNot(String email, String password) {
        return userDao.findUserByUser(new User(email, password))!=null;
    }
}
