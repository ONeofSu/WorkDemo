package org.example.workdemo.service.impl;

import org.example.workdemo.entity.User;
import org.example.workdemo.persistence.UserMapper;
import org.example.workdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public boolean login(String username, String password) {
        User user = userMapper.selectById(username);
        if(user == null){
            return false;
        }
        return user.getPassword().equals(password);
    }

    @Override
    public boolean register(String username, String password) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        userMapper.insert(user);
        return true;
    }

    @Override
    public boolean findUser(String username) {
        User user = userMapper.selectById(username);
        if(user == null){
            return false;
        }
        return true;
    }
}
