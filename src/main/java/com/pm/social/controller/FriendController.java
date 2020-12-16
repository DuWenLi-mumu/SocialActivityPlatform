package com.pm.social.controller;

import com.pm.social.Service.FriendService;
import com.pm.social.domain.Result;
import com.pm.social.domain.User;
import com.pm.social.domain.vo.UserInfo;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by 杜文丽 on 12/9/2020 3:20 PM
 **/
@RestController
@CrossOrigin
public class FriendController {
    @Autowired
    private FriendService friendService;

    @ApiOperation(value = "获取用户好友列表", notes = "获取指定用户的所有好友列表信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "用户id", required = true, dataType = "int", paramType = "query")
    })
    @GetMapping("/findUserFriendsListByUserId")
    public Result findUserFriendsListByUserId(int userId) {
        List<UserInfo> userList = friendService.findUserFriendsListByUserId(userId);
        return Result.success(userList);
    }
    @ApiOperation(value = "添加好友", notes = "针对指定用户添加好友信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "用户id", required = true, dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "friendId", value = "好友id", required = true, dataType = "int", paramType = "query")
    })
    @PostMapping("/addFriends")
    public Result addFriends(int userId,int friendId) {
        Boolean added= friendService.addFriends(userId,friendId);
        if (added){
            return Result.success("添加成功");
        }else {
            return Result.fail("添加失败");
        }

    }
}
