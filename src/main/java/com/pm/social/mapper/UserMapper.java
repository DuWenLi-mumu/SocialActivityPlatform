package com.pm.social.mapper;

import com.pm.social.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by 杜文丽 on 12/8/2020 11:14 AM
 **/
@Repository
@Mapper
public interface UserMapper {
    /**
     * 通过userId查询单个用户
     * @param id
     * @return
     */
    User findById(Integer id);

    /**
     * 查询所有用户
     * @return
     */
    List<User> findAll();



}
