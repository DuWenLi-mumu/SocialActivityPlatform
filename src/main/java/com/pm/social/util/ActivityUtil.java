package com.pm.social.util;

import com.pm.social.Service.UserService;
import com.pm.social.domain.Activity;
import com.pm.social.domain.User;
import com.pm.social.domain.vo.ActivityInfo;
import com.pm.social.domain.vo.UserCard;
import com.pm.social.domain.vo.UserInfo;
import com.pm.social.mapper.UserMapper;
import lombok.experimental.UtilityClass;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

/**
 * Created by 杜文丽 on 12/16/2020 9:45 PM
 **/
@Component
public class ActivityUtil {
    @Autowired
    private UserMapper userMapper;

    public ActivityInfo transToInfo(Activity activity) {
        ActivityInfo activityInfo = new ActivityInfo();
        activityInfo.setAddress(activity.getAddress());
        activityInfo.setBeginTime(activity.getBegin_time());
        activityInfo.setEndTime(activity.getEnd_time());
        activityInfo.setDescription(activity.getDescription());
        activityInfo.setMaxNumber(activity.getMax_number());
        activityInfo.setPeopleNumber(activity.getPeople_number());
        activityInfo.setRegistrationStartTime(activity.getRegistration_start_time());
        activityInfo.setRegistrationEndTime(activity.getRegistration_end_time());
        activityInfo.setTitle(activity.getTitle());
        int launcherId = activity.getLauncher_id();
        int orgId = activity.getOrganizer_id();
        User launcher = userMapper.findById(launcherId);
        User org = userMapper.findById(orgId);
        activityInfo.setLauncherName(launcher.getName());
        activityInfo.setOrganizerName(org.getName());
        switch (activity.getType()) {
            case 1:
                activityInfo.setType("公益活动");
                break;
            case 2:
                activityInfo.setType("教育活动");
                break;
            case 3:
                activityInfo.setType("聚会活动");
                break;
            case 4:
                activityInfo.setType("相亲活动");
                break;
            case 5:
                activityInfo.setType("体育活动");
                break;
            default:
                activityInfo.setType("其他活动");
                break;
        }
        return activityInfo;
    }
}
