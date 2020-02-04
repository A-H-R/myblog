package com.mouse.service;

import com.mouse.dao.UserRepository;
import com.mouse.po.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*
 *created by mouse on 2020/2/4
 */


@Service
public class UserServiceImpl implements UserService{

    //  dao层负责与数据库打交道，注入dao层对象
    @Autowired
    private UserRepository userRepository;

    @Override
    public User checkUser(String username, String password) {
        User user = null;
        user = userRepository.findByUsernameAndPassword(username, password);
        return user;
    }
}
