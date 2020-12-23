package com.pm.social.domain;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * Created by 杜文丽 on 12/8/2020 11:13 AM
 **/
@Data
public class Activity {
    private Integer id;
    private Integer launcher_id;
    private Integer organizer_id;
    private String begin_time;
    private String end_time;
    private String registration_start_time;
    private String registration_end_time;
    private Integer people_number;
    private String address;
    private String title;
    private String description;
    private Integer type;
    private Integer max_number;

}
