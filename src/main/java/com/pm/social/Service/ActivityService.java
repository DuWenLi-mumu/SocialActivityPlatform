package com.pm.social.Service;

import com.pm.social.domain.Activity;
import com.pm.social.domain.UserActivity;
import com.pm.social.domain.vo.ActivityInfo;
import com.pm.social.mapper.ActivityMapper;
import com.pm.social.util.ActivityUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 杜文丽 on 12/8/2020 8:02 PM
 **/
@Service
@Component
public class ActivityService {
    @Autowired
    private ActivityMapper activityMapper;
    @Autowired
    private ActivityUtil activityUtil;

    public ActivityInfo findOneActivityById(int activityId) {
        Activity activity = activityMapper.findById(activityId);
        return activityUtil.transToInfo(activity);
    }

    public List<ActivityInfo> findAllActivities() {
        List<Activity> activityList = activityMapper.findAll();
        List<ActivityInfo> result = new ArrayList<>();
        for (Activity a:activityList
             ) {
            result.add(activityUtil.transToInfo(a));
        }
        return result;
    }

    public List<ActivityInfo> findLauncherUserActivities(Integer userId) {
        List<Activity> activityList = activityMapper.findLauncherUserActivities(userId);
        List<ActivityInfo> result = new ArrayList<>();
        for (Activity a:activityList
             ) {
            result.add(activityUtil.transToInfo(a));
        }
        return result;
    }
    public List<ActivityInfo> findParticipateUserActivities(Integer userId) {
        List<UserActivity> userActivityList = activityMapper.findParticipateUserActivities(userId);
        List<ActivityInfo> activities = new ArrayList<>();
        for (int i = 0; i < userActivityList.size(); i++) {
            Activity activity = activityMapper.findById(userActivityList.get(i).getActivity_id());
            if (activity != null){
                activities.add(activityUtil.transToInfo(activity));
            }
        }
        return activities;
    }

    public int addOneActivity(Activity activity) {
        int res = activityMapper.addOneActivity(activity);
        return res;
    }
}
