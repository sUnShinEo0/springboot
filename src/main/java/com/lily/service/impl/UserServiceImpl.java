package com.lily.service.impl;

import com.lily.mapper.UserMapper;
import com.lily.pojo.User;
import com.lily.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: liling
 * @date: Created in 2020/2/22
 * @description:
 * @version:1.0
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> findAll() {
        return userMapper.findAll();
    }
}
