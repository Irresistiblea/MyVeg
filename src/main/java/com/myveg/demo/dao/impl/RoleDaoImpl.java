package com.myveg.demo.dao.impl;

import com.myveg.demo.dao.RoleDao;
import com.myveg.demo.domain.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RoleDaoImpl implements RoleDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public List<Role> findAll() {
        String sql="select * from \"User\".\"roleTable\"";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Role.class));
    }

    @Override
    public boolean deleteRoleById(int id) {
        String sql="delete from \"User\".\"roleTable\" where id = ?";
        int update = jdbcTemplate.update(sql, id);
        return update==1;
    }

    @Override
    public Role findRoleById(int id) {
        String sql="select * from \"User\".\"roleTable\" where id = ?";
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Role.class), id);
    }

    @Override
    public boolean addRole(Role role) {
        String sql="insert into \"User\".\"roleTable\" (name,email,phonenum,rolename) values(?,?,?,?)";
        int update = jdbcTemplate.update(sql, role.getName(), role.getEmail(), role.getPhoneNum(), role.getRoleName());
        return update==1;
    }

    @Override
    public boolean updateRole(int id, Role role) {
        String sql="update \"User\".\"roleTable\" set name=?,email=?,phonenum=?,rolename=? where id=?";
        int update = jdbcTemplate.update(sql,role.getName(),role.getEmail(),role.getPhoneNum(),role.getRoleName(),id);
        return update==1;
    }
}
