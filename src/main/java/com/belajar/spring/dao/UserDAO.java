package com.belajar.spring.dao;

import com.belajar.spring.entity.User;

import java.util.List;

public interface UserDAO extends BaseDAO<User> {

    List<User> findByUsername(User param);

    User findByUsernameAndPassword(String username, String password);

}
