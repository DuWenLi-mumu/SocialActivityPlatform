package com.pm.social.Service;

import com.pm.social.domain.User;
import com.pm.social.domain.vo.UserInfo;
import com.pm.social.mapper.UserMapper;
import com.pm.social.util.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 杜文丽 on 12/8/2020 6:53 PM
 **/
@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public List<UserInfo> findAllUsers() {
        List<User> userList = userMapper.findAll();
        List<UserInfo> res = new ArrayList<>();
        for (User u:userList
             ) {
            res.add(UserUtil.transToInfo(u));
        }
        return res;
    }

    public UserInfo findOneUser(int userId) {
        User user = userMapper.findById(userId);
        if (user == null){
            return null;
        }
        UserInfo userInfo = UserUtil.transToInfo(user);
        return userInfo;
    }
}
