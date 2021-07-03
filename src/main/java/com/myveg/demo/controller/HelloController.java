package com.myveg.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class HelloController {
    @RequestMapping("/Hi")
    public String sayHello(){
        return "pages/all-admin-login";
    }
    @RequestMapping(value = "/toPage")
    public String toPage(HttpServletRequest request){
        String url = request.getParameter("url");
        if (!url.contains(".html")){
            //没有.html就去掉斜杠
            StringBuilder sb=new StringBuilder();
            char[] chars = url.toCharArray();
            for(int i=1;i<chars.length;i++){
                sb.append(chars[i]);
            }
            System.out.println(sb.toString());
            return sb.toString();
        }else {
            //有就不去掉
            return url;
        }

    }
    @RequestMapping("/register")
    public String goRegister(){
        return "pages/all-admin-register";
    }
}
