package com.pm.social.controller;

import com.pm.social.Service.CardService;
import com.pm.social.domain.Result;
import com.pm.social.domain.User;
import com.pm.social.domain.vo.UserCard;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by 杜文丽 on 12/8/2020 7:51 PM
 **/
@RestController
@CrossOrigin
public class CardController {
    @Autowired
    private CardService cardService;

    @ApiOperation(value = "获取单个用户的卡片信息", notes = "通过用户id获取该用户的卡片信息")
    @GetMapping("/findOneUserCard")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "用户id", required = true, dataType = "int", paramType = "query")
    })
    public Result findOneUserCard(int userId) {
        UserCard userCard = cardService.findOneUserCard(userId);
        if (userCard == null){
            return Result.fail("用户卡片不存在");
        }else {
            return Result.success(userCard);
        }
    }

    @ApiOperation(value = "获取所有的卡片信息", notes = "获取所有用户的卡片信息")
    @GetMapping("/findAllUserCard")
    public Result findAllUserCard() {
        List<UserCard> userCardList = cardService.findAllUserCard();
        return Result.success(userCardList);
    }
}
