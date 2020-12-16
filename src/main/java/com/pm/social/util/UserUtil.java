package com.pm.social.util;

import com.pm.social.domain.User;
import com.pm.social.domain.vo.UserInfo;
import com.pm.social.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by 杜文丽 on 12/16/2020 10:02 PM
 **/
public class UserUtil {
    @Autowired
    private static UserMapper userMapper;
    public static UserInfo transToInfo(User user){
        UserInfo userInfo = new UserInfo();
        userInfo.setAddr(user.getAddr());
        userInfo.setDescription(user.getDescription());
        userInfo.setId(user.getId());
        userInfo.setPhone(user.getPhone());
        switch (user.getRole()){
            case 1: userInfo.setRole("机构");break;
            case 2: userInfo.setRole("社交企业");break;
            case 3: userInfo.setRole("管理员");break;
            default:userInfo.setRole("普通用户");break;
        }
        return userInfo;

    }
}
