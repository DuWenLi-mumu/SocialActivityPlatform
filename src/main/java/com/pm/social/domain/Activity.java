package com.pm.social.domain;

import lombok.Data;

import java.util.Date;

/**
 * Created by 杜文丽 on 12/8/2020 11:13 AM
 **/
@Data
public class Activity {
    private Integer id;
    private Integer launcherId;
    private Date time;
    private String address;
    private String description;
    private Integer type;

}
