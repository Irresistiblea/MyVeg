package com.myveg.demo.service.impl;

import com.myveg.demo.dao.RoleDao;
import com.myveg.demo.domain.Role;
import com.myveg.demo.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleDao roleDao;
    @Override
    public List<Role> showAllRoles() {
        return roleDao.findAll();
    }

    @Override
    public boolean deleteRoleById(int id) {
        return roleDao.deleteRoleById(id);
    }

    @Override
    public Role findRoleById(int id) {
       if(roleDao.findRoleById(id)!=null){
           return roleDao.findRoleById(id);
       }
       return null;
    }

    @Override
    public boolean updateRole(int id,Role role) {
        if (id!=0){
            //更改用户
            roleDao.updateRole(id,role);
        }else {
            //添加用户
            roleDao.addRole(role);
        }
        return false;
    }
}
