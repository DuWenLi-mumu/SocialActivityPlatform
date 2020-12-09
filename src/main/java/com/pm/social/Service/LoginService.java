package com.pm.social.Service;

import com.pm.social.domain.User;
import com.pm.social.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * Created by 杜文丽 on 12/8/2020 2:29 PM
 **/
@Service
@Component
public class LoginService {

    @Autowired
    private UserMapper userMapper;

    public Boolean UserExist(Integer userId) {
        User user = userMapper.findById(userId);
        if (user != null){
            return true;
        }else{
            return false;
        }
    }


}
