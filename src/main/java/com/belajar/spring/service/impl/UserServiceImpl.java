package com.belajar.spring.service.impl;

import com.belajar.spring.dao.UserDAO;
import com.belajar.spring.dao.impl.UserDAOImpl;
import com.belajar.spring.entity.User;
import com.belajar.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Override
    public User save(User param) {
        return userDAO.save(param);
    }

    @Override
    public User update(User param){
        return userDAO.update(param);
    }

    @Override
    public int delete(User param) {
        return userDAO.delete(param);
    }

    @Override
    public User findById(int id) {
        return userDAO.findById(id);
    }

    @Override
    public List<User> find() {
        return userDAO.find();
    }

    @Override
    public List<User> findByUsername(User param) {
        return userDAO.findByUsername(param);
    }

    @Override
    public User findByUsernameAndPassword(String username, String password) {
        User login = userDAO.findByUsernameAndPassword(username, password);
        if (login != null) {
            return login;
        }

        return null;
    }
}
