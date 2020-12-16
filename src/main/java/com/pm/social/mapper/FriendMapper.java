package com.pm.social.mapper;

import com.pm.social.domain.Friend;
import com.pm.social.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by 杜文丽 on 12/9/2020 3:13 PM
 **/
@Repository
@Mapper
public interface FriendMapper {
    List<Friend> findFriendsById(int userId);
    List<Friend> findAll();

    Integer addFriends(int userId, int friendId);
}
