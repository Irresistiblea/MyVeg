package com.myveg.demo.controller;

import com.myveg.demo.domain.Role;
import com.myveg.demo.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.io.*;
import java.util.List;

@Controller
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private RoleService roleService;

    @RequestMapping("/findAll")
    public ModelAndView findAll(){
        ModelAndView modelAndView=new ModelAndView();
        List<Role> roles = roleService.showAllRoles();
        modelAndView.addObject("roleList",roles);
        modelAndView.setViewName("pages/role_list");
        return modelAndView;
    }

    @RequestMapping("/deleteRole")
    public String deleteRole(@RequestParam("id")int id){
        boolean deleteOrNot = roleService.deleteRoleById(id);
        System.out.println(id+" 删除 "+deleteOrNot);
        return "redirect:/role/findAll";
    }
//    转入用户信息编辑页面
    @RequestMapping("/roleAdd")
    public ModelAndView roleAdd(@RequestParam(value = "id",defaultValue = "0")int id) throws IOException {
        ModelAndView modelAndView=new ModelAndView();
        Role role;
        if (id!=0){
            role = roleService.findRoleById(id);
            modelAndView.addObject("editOrNot","true");
        }else {
            role=new Role();
            role.setId(0);
            role.setName(" ");
            role.setEmail(" ");
            role.setPhoneNum(0);
            role.setRoleName(" ");
            modelAndView.addObject("editOrNot","false");
        }
        modelAndView.addObject("thisRole",role);
        modelAndView.setViewName("pages/role-add");




        return modelAndView;
    }
    //用户信息表单提交
    @RequestMapping("/roleUpdate")
    public String updateRole(@RequestParam(value = "id",defaultValue = "0")int id,
                             @RequestParam("name")String name,
                             @RequestParam("email")String email,
                             @RequestParam("role")String roleName,
                             @RequestParam("phoneNum")long phoneNum){
        Role role=new Role();
        role.setId(id);
        role.setName(name);
        role.setEmail(email);
        role.setRoleName(roleName);
        role.setPhoneNum(phoneNum);
        System.out.println(role);
        roleService.updateRole(id,role);
        return "redirect:/role/findAll";
    }
}
