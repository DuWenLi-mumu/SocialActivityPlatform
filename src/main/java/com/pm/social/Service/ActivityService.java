package com.pm.social.Service;

import com.pm.social.domain.Activity;
import com.pm.social.mapper.ActivityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 杜文丽 on 12/8/2020 8:02 PM
 **/
@Service
public class ActivityService {
    @Autowired
    private ActivityMapper activityMapper;

    public Activity findOneActivityById(int activityId) {
        Activity activity = activityMapper.findById(activityId);
        return activity;
    }

    public List<Activity> findUserActivities(int userId){
        List<Activity> activityList = activityMapper.findUserActivities(userId);
        return activityList;
    }

    public List<Activity> findAllActivities() {
        List<Activity> activityList = activityMapper.findAll();
        return activityList;
    }
}
