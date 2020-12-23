package com.pm.social.controller;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.pm.social.Service.ActivityService;
import com.pm.social.domain.Activity;
import com.pm.social.domain.Result;
import com.pm.social.domain.vo.ActivityInfo;
import com.pm.social.domain.vo.UserCard;
import com.pm.social.mapper.ActivityMapper;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.naming.InsufficientResourcesException;
import java.util.Date;
import java.util.List;

/**
 * Created by 杜文丽 on 12/8/2020 8:02 PM
 **/
@RestController
@CrossOrigin
public class ActivityController {
    @Autowired
    private ActivityService activityService;

    @ApiOperation(value = "获取发布的所有活动", notes = "获取发布的所有活动")
    @GetMapping("/findAllActivities")
    public Result findAllActivities() {
        List<ActivityInfo> activityList = activityService.findAllActivities();
        return Result.success(activityList);
    }

    @ApiOperation(value = "获取该用户发布的所有活动", notes = "获取单个用户发布的所有活动")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "用户id", required = true, dataType = "int", paramType = "query")
    })
    @GetMapping("/findLauncherUserActivities")
    public Result findUserActivities(Integer userId) {
        List<ActivityInfo> activityList = activityService.findLauncherUserActivities(userId);
        return Result.success(activityList);
    }

    @ApiOperation(value = "获取该用户参与的所有活动", notes = "获取单个用户参与的所有活动")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "用户id", required = true, dataType = "int", paramType = "query")
    })
    @GetMapping("/findParticipateUserActivities")
    public Result findParticipateUserActivities(Integer userId) {
        List<ActivityInfo> activityList = activityService.findParticipateUserActivities(userId);
        return Result.success(activityList);
    }

    @ApiOperation(value = "获取单个活动", notes = "通过活动id获取单个活动信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "activityId", value = "活动id", required = true, dataType = "int", paramType = "query")
    })
    @GetMapping("/findOneActivityById")
    public Result findOneActivityById(int activityId) {
        ActivityInfo activity = activityService.findOneActivityById(activityId);
        if (activity == null){
            return Result.fail("该活动不存在");
        }else {
            return Result.success(activity);
        }

    }

    @ApiOperation(value = "新增一个活动", notes = "新增一个活动")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "launcherId", value = "发起人id", required = false, dataType = "int", paramType = "query",defaultValue = "1"),
            @ApiImplicitParam(name = "organizerId", value = "机构id", required = true, dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "beginTimeSec", value = "活动开始时间", required = true, dataType = "String", paramType = "query",defaultValue = ""),
            @ApiImplicitParam(name = "endTimeSec", value = "活动结束时间", required = true, dataType = "String", paramType = "query",defaultValue = ""),
            @ApiImplicitParam(name = "registrationStartTimeSec", value = "报名开始时间", required = true, dataType = "String", paramType = "query",defaultValue = ""),
            @ApiImplicitParam(name = "registrationEndTimeSec", value = "报名结束时间", required = true, dataType = "String", paramType = "query",defaultValue = ""),
            @ApiImplicitParam(name = "peopleNumber", value = "活动当前人数", required = false, dataType = "int",defaultValue = "0"),
            @ApiImplicitParam(name = "address", value = "活动地点", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "title", value = "活动名称", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "desc", value = "活动描述", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "type", value = "活动类型", required = true, dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "maxNumber", value = "活动最大人数", required = true, dataType = "int", paramType = "query"),
    })
    @PostMapping("/addOneActivity")
    public Result addOneActivity(Integer launcherId, Integer organizerId, String beginTimeSec, String endTimeSec,String registrationStartTimeSec,String registrationEndTimeSec, Integer peopleNumber, String address,
                                 String title, String desc, Integer type, Integer maxNumber) {
        Activity activity = new Activity();
        activity.setLauncher_id(launcherId);
        activity.setOrganizer_id(organizerId);
        activity.setBegin_time(beginTimeSec);
        activity.setEnd_time(endTimeSec);
        activity.setRegistration_start_time(registrationStartTimeSec);
        activity.setRegistration_end_time(registrationEndTimeSec);
        activity.setPeople_number(peopleNumber);
        activity.setAddress(address);
        activity.setTitle(title);
        activity.setDescription(desc);
        activity.setType(type);
        activity.setMax_number(maxNumber);
        int res = activityService.addOneActivity(activity);
        if (res == 1){
            return Result.fail("添加活动成功");
        }else {
            return Result.success("添加活动失败");
        }

    }

}
