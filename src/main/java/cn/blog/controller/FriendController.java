package cn.blog.controller;

import cn.blog.entity.Frienduser;
import cn.blog.entity.User;
import cn.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author whai_luo
 * @Date: 2020/7/6 9:52
 */
@RequestMapping("/friend")
@Controller
public class FriendController {

    @Autowired
    UserService userService;
    /**
     * 添加朋友
     * @param userId
     * @param session
     * @return
     */
    @RequestMapping(value = "/addFriend/{userId}")
    public String addFriend(@PathVariable Integer userId, HttpSession session){
        //当前用户user
        User user = (User) session.getAttribute("user");
        //捆绑
        Frienduser frienduser = new Frienduser(user.getUserId(), userId);
        //查询是否已经是好友
        if ((userService.findFrinedBind(frienduser)==0)&&(!user.getUserId().equals(userId))){
            //还不是好友 不能加自己
            userService.addFriend(frienduser);
        }
        //更新好友信息
        List<User> friendsUser = userService.getFriendUser(user.getUserId());
        session.setAttribute("allFriends",friendsUser);
        return "redirect:/userPage/"+userId;
    }

    /**
     * 添加朋友
     * @param userId
     * @param session
     * @return
     */
    @RequestMapping(value = "/deleteFriend/{userId}")
    public String deleteFriend(@PathVariable Integer userId, HttpSession session){
        User user = (User) session.getAttribute("user");
        Frienduser frienduser = new Frienduser(user.getUserId(), userId);
        if ((userService.findFrinedBind(frienduser))!=0&&(!user.getUserId().equals(userId))){
            userService.deleteFriend(frienduser);
            //是好友 可以删除 不能加自己
        }
        //更新好友信息
        List<User> friendsUser = userService.getFriendUser(user.getUserId());
        session.setAttribute("allFriends",friendsUser);
        return "redirect:/userPage/"+userId;
    }
}
