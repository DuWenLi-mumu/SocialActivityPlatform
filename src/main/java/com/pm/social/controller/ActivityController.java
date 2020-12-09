package com.pm.social.controller;

import com.pm.social.Service.ActivityService;
import com.pm.social.domain.Activity;
import com.pm.social.domain.Result;
import com.pm.social.domain.vo.UserCard;
import com.pm.social.mapper.ActivityMapper;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by 杜文丽 on 12/8/2020 8:02 PM
 **/
@RestController
public class ActivityController {
    @Autowired
    private ActivityService activityService;

    @ApiOperation(value = "获取发布的所有活动", notes = "获取发布的所有活动")
    @GetMapping("/findAllActivities")
    public Result findAllActivities() {
        List<Activity> activityList = activityService.findAllActivities();
        return Result.success(activityList);
    }

    @ApiOperation(value = "获取该用户发布的所有活动", notes = "获取单个用户发布的所有活动")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "用户id", required = true, dataType = "int", paramType = "query")
    })
    @GetMapping("/findUserActivities")
    public Result findUserActivities(Integer userId) {
        List<Activity> activityList = activityService.findUserActivities(userId);
        return Result.success(activityList);
    }

    @ApiOperation(value = "获取单个活动", notes = "通过活动id获取单个活动信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "activityId", value = "活动id", required = true, dataType = "int", paramType = "query")
    })
    @GetMapping("/findOneActivityById")
    public Result findOneActivityById(int activityId) {
        Activity activity = activityService.findOneActivityById(activityId);
        if (activity == null){
            return Result.fail("该活动不存在");
        }else {
            return Result.success(activity);
        }

    }

}
