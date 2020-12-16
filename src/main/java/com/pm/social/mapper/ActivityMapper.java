package com.pm.social.mapper;

import com.pm.social.domain.Activity;
import com.pm.social.domain.User;
import com.pm.social.domain.UserActivity;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by 杜文丽 on 12/8/2020 11:17 AM
 **/
@Component
public interface ActivityMapper {
    /**
     * 通过activityId查询单个activity
     * @param id
     * @return
     */
    Activity findById(Integer id);
    List<Activity> findAll();

    List<Activity> findLauncherUserActivities(Integer userId);
    List<UserActivity> findParticipateUserActivities(Integer userId);
}
