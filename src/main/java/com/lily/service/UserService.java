package com.lily.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.lily.pojo.User;

import java.util.List;

public interface UserService {

    List<User> findAll() throws JsonProcessingException;

}
