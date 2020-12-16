package com.pm.social.controller;

import com.pm.social.Service.UserService;
import com.pm.social.domain.Card;
import com.pm.social.domain.Result;
import com.pm.social.domain.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 杜文丽 on 12/8/2020 2:45 PM
 **/
@RestController
@CrossOrigin
public class UserController {
    @Autowired
    private UserService userService;

    @ApiOperation(value = "获取用户列表", notes = "获取所有用户信息")
    @GetMapping("/findAllUsers")
    public Result findAllUsers() {
        List<User> userList = userService.findAllUsers();
        return Result.success(userList);
    }

    @ApiOperation(value = "获取单个用户信息", notes = "获取单个用户的信息")
    @GetMapping("/findOneUser")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "用户id", required = true, dataType = "int", paramType = "query")
    })
    public Result findOneUser(int userId) {
        User user = userService.findOneUser(userId);
        if (user == null){
            return Result.fail("用户不存在");
        }else {
            return Result.success(user);
        }
    }
}
