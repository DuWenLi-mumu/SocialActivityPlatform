package com.pm.social.controller;

import com.pm.social.Service.LoginService;
import com.pm.social.domain.Result;
import com.pm.social.domain.User;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by 杜文丽 on 12/8/2020 2:27 PM
 **/
@RestController
@CrossOrigin
public class LoginController {
    @Autowired
    private LoginService loginService;

    @ApiOperation(value = "检查用户存在与否")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "用户id", required = true, dataType = "Integer", paramType = "query"),
            })
    @GetMapping("/login")
    public Result findUser(Integer userId) {
        if (loginService.UserExist(userId)){
            return Result.success();
        }else {
            return Result.fail("用户不存在");
        }
    }
}
