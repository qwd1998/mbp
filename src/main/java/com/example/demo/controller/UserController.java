package com.example.demo.controller;

import com.example.demo.pojo.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import javax.servlet.http.HttpSession;
import java.util.Map;


@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public String queryOne(@RequestParam(name = "username", required = true) String username, @RequestParam(name = "password", required = true) String password, Map<String, Object> map, HttpSession session) {
        User user = this.userService.QueryUser(username, password);
        //判断是否查询到这个用户
        if (user != null) {
            //用户存在，保存登录用户的姓名到session中
            session.setAttribute("user", user.getUsername());
            //跳转到登录成功页面
            return "success";
        } else {
            //用户不存在保存错误信息
            map.put("msg", "用户名或密码错误");
            //跳转到登陆页面，在登录页面显示错误信息
            return "login";
        }

    }

}
