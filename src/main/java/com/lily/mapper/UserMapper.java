package com.lily.mapper;

import com.lily.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: liling
 * @date: Created in 2020/2/22
 * @description:
 * @version:1.0
 */
@Repository
@Mapper
public interface UserMapper {

    List<User> findAll();

}
