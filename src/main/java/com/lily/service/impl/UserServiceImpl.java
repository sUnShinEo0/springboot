package com.lily.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lily.mapper.UserMapper;
import com.lily.pojo.User;
import com.lily.service.UserService;
import io.netty.util.internal.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
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

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public List<User> findAll() throws JsonProcessingException {
        //从redis缓存读取
        String users = (String) redisTemplate.boundValueOps("user:findAll").get();
        ObjectMapper objectMapper = new ObjectMapper();
        //判断缓存是否存在
        if (StringUtil.isNullOrEmpty(users)){
            System.out.println("UserServiceImpl.findAll" + "===数据库读取");
            //不存在, 从数据库读取
            List<User> all = userMapper.findAll();
            //缓存到redis中
            redisTemplate.boundValueOps("user:findAll").set(objectMapper.writeValueAsString(all));
            return all;
        }
        //存在, 直接返回缓存数据
        System.out.println("UserServiceImpl.findAll" + "===缓存读取");
        return objectMapper.readValue(users, new TypeReference<List<User>>() {});
    }
}
