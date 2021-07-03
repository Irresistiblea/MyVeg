package com.myveg.demo.controller;

import com.myveg.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class LoginController {

    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    public String login(
            @RequestParam("email") String email,
            @RequestParam("password") String password,
            Map<String,Object> map,
            HttpSession session
    ){
        if(userService.loginOrNot(email,password)){
            //登录成功
            session.setAttribute("loginUser",email);
            return "redirect:/index.html";
        }
        else {
            //登录失败
            map.put("msg","用户名或密码错误");
            return "pages/all-admin-login";
        }
    }
    /**
     * 用户注销
     */
    @RequestMapping("/logout")
    public String logoutt(HttpSession session){
        try{
            Object loginUser = session.getAttribute("loginUser");
            if (loginUser!=null){
                System.out.println(loginUser);
                session.removeAttribute("loginUser");
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return "redirect:/login.html";
    }
    /**
     * 注册方法
     */
    @RequestMapping("/toRegister")
    public String register(
            @RequestParam("name") String name,
            @RequestParam("email") String email,
            @RequestParam("password") String password
    ){
        return "redirect:/login.html";
    }
}
