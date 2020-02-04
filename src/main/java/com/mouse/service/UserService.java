package com.mouse.service;
/*
 *created by mouse on 2020/2/4
 */

import com.mouse.po.User;

public interface UserService {
    User checkUser(String username, String password);
}
