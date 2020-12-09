package com.pm.social.domain;

import lombok.Data;

/**
 * Created by 杜文丽 on 12/9/2020 3:10 PM
 **/
@Data
public class Friend {
    private Integer id;
    private Integer user_id;
    private Integer friend_id;
}
