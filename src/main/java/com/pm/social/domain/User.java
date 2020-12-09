package com.pm.social.domain;

import lombok.Data;

/**
 * Created by 杜文丽 on 12/8/2020 11:10 AM
 **/
@Data
public class User {
    private Integer id;
    private String name;
    private Integer role;
    private String addr;
    private String description;
    private String phone;
    private String username;
    private String passwd;
}
