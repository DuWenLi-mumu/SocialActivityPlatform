package com.pm.social.domain;

import io.swagger.models.auth.In;
import lombok.Data;

/**
 * Created by 杜文丽 on 12/8/2020 11:12 AM
 **/
@Data
public class Card {
    private Integer id;
    private Integer templateId;
    private Integer userId;

    public Card(Integer id, Integer templateId, Integer userId) {
        this.id = id;
        this.templateId = templateId;
        this.userId = userId;
    }
}
