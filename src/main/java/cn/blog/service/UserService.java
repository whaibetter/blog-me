package cn.blog.service;

import cn.blog.entity.Frienduser;
import cn.blog.entity.LookUser;
import cn.blog.entity.User;
import cn.blog.entity.vo.LookUserVo;
import cn.blog.entity.vo.UserArticle;


import java.util.List;

/**
 * @author whai_luo
 * @Date: 2020/7/3 14:06
 */
public interface UserService {

    User loginVerify(User user);

    List<LookUserVo> getlookMeUser(Integer userId);

    int addLookMeUser(LookUser lookUser);

    List<User> getFriendUser(Integer userId);

    int addFriend(Frienduser frienduser);

    int deleteFriend(Frienduser frienduser);

    UserArticle getUserInfoAndArticle( Integer userId);

    User getUser(Integer userId);

    int insertUser(User user);

    List<User> searchUser(String username);

    /**
     * 查询有没有这个好友 有没有捆绑
     * @param frienduser
     * @return
     */
    int findFrinedBind(Frienduser frienduser);

    User usernameVerify(String username);
}
