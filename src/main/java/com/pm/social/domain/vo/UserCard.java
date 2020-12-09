package com.pm.social.domain.vo;

import lombok.Data;

/**
 * Created by 杜文丽 on 12/8/2020 7:39 PM
 **/
@Data
public class UserCard {
    private String name;
    private String role;
    private String addr;
    private String description;
    private String phone;
    private Integer templateId;
}
