package com.pm.social.domain.vo;

import lombok.Data;

/**
 * Created by 杜文丽 on 12/16/2020 9:59 PM
 **/
@Data
public class UserInfo {
    private Integer id;
    private String name;
    private String role;
    private String addr;
    private String description;
    private String phone;
}
