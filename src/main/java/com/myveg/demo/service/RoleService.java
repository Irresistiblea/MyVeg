package com.myveg.demo.service;

import com.myveg.demo.domain.Role;

import java.util.List;

public interface RoleService {
    public List<Role> showAllRoles();
    public boolean deleteRoleById(int id);
    public Role findRoleById(int id);
    public boolean updateRole(int id,Role role);
}
