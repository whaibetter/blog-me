package cn.blog.service.impl;

import cn.blog.entity.Article;
import cn.blog.entity.Frienduser;
import cn.blog.entity.LookUser;
import cn.blog.entity.User;
import cn.blog.entity.vo.LookUserVo;

import cn.blog.entity.vo.UserArticle;
import cn.blog.mapper.*;
import cn.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author whai_luo
 * @Date: 2020/7/3 14:06
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Autowired
    ArticleMapper articleMapper;

    @Autowired
    CommentMapper commentMapper;

    @Autowired
    FrienduserMapper frienduserMapper;

    @Autowired
    LookuserMapper lookuserMapper;


    @Override
    public User loginVerify(User user) {
        user=userMapper.loginVerify(user);
        return user;
    }

    @Override
    public List<LookUserVo> getlookMeUser(Integer userId) {
        List<LookUserVo> result = new ArrayList<>();
        //根据userid 知道谁看了我
        List<LookUser> lookusers = lookuserMapper.selectLookMeUser(userId);
        for (LookUser lookuser : lookusers) {
            //获取每个看了我的人的id
            Integer lookUserId = lookuser.getLookUserId();
            //每个人看的时间
            Date lookDate = lookuser.getLookDate();
            //根据每个人的id获取那个人的信息
            User user = userMapper.selectUserInfo(lookUserId);
            result.add(new LookUserVo(user,lookDate));
        }
        return result;
    }


    @Override
    public int addLookMeUser(LookUser lookUser) {
        //谁看了我 添加看的人id 和日期
        return lookuserMapper.insert(lookUser);
    }

    @Override
    public List<User> getFriendUser(Integer userId) {
        //获取我全部好友的id
        List<Integer> integers = frienduserMapper.selectFriendIdByUserId(userId);

        List<User> friendUserResult = new ArrayList<>();
        for (Integer integer : integers) {
            //根据好友id获取好友信息
            User user = userMapper.selectUserInfo(integer);
            friendUserResult.add(user);
        }
        return friendUserResult;
    }

    @Override
    public int addFriend(Frienduser frienduser) {
        return frienduserMapper.insertFriend(frienduser);
    }

    @Override
    public int deleteFriend(Frienduser frienduser) {
        return frienduserMapper.deleteFriend(frienduser);
    }

    @Override
    public UserArticle getUserInfoAndArticle(Integer userId) {
        //查询user信息
        User user = userMapper.selectByPrimaryKey(userId);

        //获取文章信息
        List<Article> articles = articleMapper.selectArticlesTitleByUserId(user.getUserId());

        return new UserArticle(user,articles);
    }

    @Override
    public User getUser(Integer userId) {
        //根据userid获取user信息
        User user = userMapper.selectByPrimaryKey(userId);
        return user;
    }


    @Override
    public int insertUser(User user) {
        return userMapper.insertSelective(user);
    }

    @Override
    public List<User> searchUser(String username) {
        List<User> users = userMapper.searchUser(username);
        return users;
    }

    @Override
    public int findFrinedBind(Frienduser frienduser) {
        return frienduserMapper.selectFriendBind(frienduser);
    }

    @Override
    public User usernameVerify(String username) {
        return userMapper.usernameVerify(username);
    }


}
