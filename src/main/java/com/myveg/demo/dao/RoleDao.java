package com.myveg.demo.dao;

import com.myveg.demo.domain.Role;

import java.util.List;

public interface RoleDao {
    public List<Role> findAll();
    public boolean deleteRoleById(int id);
    public Role findRoleById(int id);
    public boolean addRole(Role role);
    public boolean updateRole(int id,Role role);
}
