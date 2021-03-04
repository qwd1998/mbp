package com.example.demo.service;

import com.example.demo.mapper.UserMapper;
import com.example.demo.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


public interface UserService {


     /**
      * 根据用户的姓名和密码查询用户是否存在
      * @param username
      * @param password
      * @return
      */
     User QueryUser(String username,String password);
}
