package com.pm.social.Service;

import com.pm.social.domain.User;
import com.pm.social.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 杜文丽 on 12/8/2020 6:53 PM
 **/
@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public List<User> findAllUsers() {
        List<User> userList = userMapper.findAll();
        return userList;
    }

    public User findOneUser(int userId) {
        User user = userMapper.findById(userId);
        return user;
    }
}
