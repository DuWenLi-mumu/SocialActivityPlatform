package com.pm.social.domain.vo;

import lombok.Data;

import java.util.Date;

/**
 * Created by 杜文丽 on 12/16/2020 9:40 PM
 **/
@Data
public class ActivityInfo {
    private Integer id;
    private String launcherName;
    private String organizerName;
    private Date beginTime;
    private Date endTime;
    private Date registrationStartTime;
    private Date registrationEndTime;
    private Integer peopleNumber;
    private String address;
    private String title;
    private String description;
    private String type;
    private Integer maxNumber;
}
