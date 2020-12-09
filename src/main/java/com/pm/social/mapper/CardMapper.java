package com.pm.social.mapper;

import com.pm.social.domain.Card;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by 杜文丽 on 12/8/2020 11:16 AM
 **/
@Component
public interface CardMapper {
    /**
     * 通过cardId查询单个card
     * @param id
     * @return
     */
    Card findById(Integer id);
    Card findByUserId(Integer id);
    List<Card> findAll();
}
