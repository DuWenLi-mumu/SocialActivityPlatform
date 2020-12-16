package com.pm.social.domain;

import lombok.Data;

import java.util.Date;

/**
 * Created by 杜文丽 on 12/8/2020 11:13 AM
 **/
@Data
public class Activity {
    private Integer id;
    private Integer launcher_id;
    private Integer organizer_id;
    private Date begin_time;
    private Date end_time;
    private Date registration_start_time;
    private Date registration_end_time;
    private Integer people_number;
    private String address;
    private String title;
    private String description;
    private Integer type;


}
