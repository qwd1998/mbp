package com.example.demo.service.impl;

import com.example.demo.mapper.UserMapper;
import com.example.demo.pojo.User;
import com.example.demo.service.UserService;
import com.example.demo.utils.Mdk5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    /**
     * 根据用户的姓名和密码查询用户是否存在
     * @param username
     * @param password
     * @return
     */
    public User QueryUser(String username, String password){
        User user = new User();
        user.setUsername(username);

        //使用mdk5加密
        String real_password = Mdk5.string2MD5(password);
        user.setPassword(real_password);
        User u = this.userMapper.selectOne(user);
        return u;
    }
}
