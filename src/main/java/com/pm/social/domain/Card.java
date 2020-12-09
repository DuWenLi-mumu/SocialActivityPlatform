package com.pm.social.domain;

import io.swagger.models.auth.In;
import lombok.Data;

/**
 * Created by 杜文丽 on 12/8/2020 11:12 AM
 **/
@Data
public class Card {
    private Integer id;
    private Integer template_id;
    private Integer userId;

    public Card(Integer id, Integer templateId, Integer userId) {
        this.id = id;
        this.template_id = templateId;
        this.userId = userId;
    }
}
