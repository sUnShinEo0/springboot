package com.lily.collector;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lily.pojo.User;
import com.lily.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author: liling
 * @date: Created in 2020/2/22
 * @description:
 * @version:1.0
 */
@RestController
public class UserCollector {


    @Autowired
    private UserService userService;

    @RequestMapping("/findAll")
    public String findAll() throws JsonProcessingException {
        List<User> all = userService.findAll();
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(all);
    }


}
