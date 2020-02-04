package com.mouse.dao;
/*
 *created by mouse on 2020/2/4
 */

import com.mouse.po.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    User findByUsernameAndPassword(String username, String password);
}
