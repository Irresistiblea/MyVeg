package com.myveg.demo.dao.impl;

import com.myveg.demo.dao.UserDao;
import com.myveg.demo.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public User findUserByUser(User loginUser) {
        String sql="SELECT * FROM \"User\".\"loginTable\" where email = ? and password = ?";
        try{
            User user = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(User.class),loginUser.getEmail() ,loginUser.getPassword());
            return user;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
