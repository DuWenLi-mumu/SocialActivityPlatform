package com.pm.social.Service;

import com.pm.social.domain.Friend;
import com.pm.social.domain.User;
import com.pm.social.domain.vo.UserInfo;
import com.pm.social.mapper.FriendMapper;
import com.pm.social.mapper.UserMapper;
import com.pm.social.util.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 杜文丽 on 12/9/2020 3:21 PM
 **/
@Service
@Component
public class FriendService {
    @Autowired
    private FriendMapper friendMapper;
    @Autowired
    private UserMapper userMapper;

    public List<UserInfo> findUserFriendsListByUserId(int userId) {
        List<Friend> friendList = friendMapper.findFriendsById(userId);
        List<UserInfo> friends = new ArrayList<>();
        for (Friend f:friendList
             ) {
            User user = userMapper.findById(f.getFriend_id());
            if (user != null){
                friends.add(UserUtil.transToInfo(user));
            }
        }
        return friends;
    }

    public Boolean addFriends(int userId, int friendId) {
        Integer added = friendMapper.addFriends(userId,friendId) + friendMapper.addFriends(friendId,userId);
        if (added >= 2){
            return true;
        }
        return false;
    }
}
