package com.pm.social.Service;

import com.pm.social.domain.Friend;
import com.pm.social.domain.User;
import com.pm.social.mapper.FriendMapper;
import com.pm.social.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 杜文丽 on 12/9/2020 3:21 PM
 **/
@Service
public class FriendService {
    @Autowired
    private FriendMapper friendMapper;
    @Autowired
    private UserMapper userMapper;

    public List<User> findUserFriendsListByUserId(int userId) {
        List<Friend> friendList = friendMapper.findFriendsById(userId);
        List<User> friends = new ArrayList<>();
        for (Friend f:friendList
             ) {
            User user = userMapper.findById(f.getFriend_id());
            if (user != null){
                friends.add(user);
            }
        }
        return friends;
    }
}
