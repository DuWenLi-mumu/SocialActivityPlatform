package com.pm.social.Service;

        import com.pm.social.domain.Card;
        import com.pm.social.domain.User;
        import com.pm.social.domain.vo.UserCard;
        import com.pm.social.mapper.CardMapper;
        import com.pm.social.mapper.UserMapper;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Service;

        import java.util.ArrayList;
        import java.util.List;

/**
 * Created by 杜文丽 on 12/8/2020 7:00 PM
 **/
@Service
public class CardService {
    @Autowired
    private CardMapper cardMapper;
    @Autowired
    private UserMapper userMapper;


    public UserCard findOneUserCard(int userId) {
        //通过用户id找到用户对应的card
        Card card = cardMapper.findByUserId(userId);
        if (card == null){
            return null;
        }
        User user = userMapper.findById(card.getUserId());

        UserCard userCard = new UserCard();
        userCard.setAddr(user.getAddr());
        userCard.setDescription(user.getDescription());
        userCard.setName(user.getName());
        userCard.setPhone(user.getPhone());
        userCard.setTemplateId(card.getTemplate_id());
        switch (user.getRole()) {
            case 1:
                userCard.setRole("学校");
                break;
            case 2:
                userCard.setRole("社交企业");
                break;
            case 3:
                userCard.setRole("公司集团");
                break;
            default:
                userCard.setRole("普通用户");
                break;
        }
        return userCard;
    }

    public List<UserCard> findAllUserCard() {
        List<User> userList = userMapper.findAll();
        List<UserCard> userCardList = new ArrayList<>();
        for (User user:userList
        ) {
            UserCard userCard = findOneUserCard(user.getId());
            if (userCard != null){
                userCardList.add(userCard);
            }
        }
        return userCardList;
    }
}
