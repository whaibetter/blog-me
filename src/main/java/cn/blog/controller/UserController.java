package cn.blog.controller;


import cn.blog.entity.User;
import cn.blog.entity.vo.UserArticle;
import cn.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author whai_luo
 * @Date: 2020/7/4 9:41
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    /**
     * 查询
     *      用户
     * 和
     *      用户的所有文章的元数据
     * @param userId
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/{userId}")
    @ResponseBody //适合RESTful
    public ModelAndView getUserInfoAndArticleInfo(@PathVariable("userId") Integer userId) throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        //包含文章部分信息的user信息
        UserArticle userInfoAndArticle = userService.getUserInfoAndArticle(userId);
        modelAndView.addObject("userInfoAndArticle", userInfoAndArticle);
        modelAndView.setViewName("/detail");
        return modelAndView;
    }


    /**
     * 模糊查询人员
     * @return
     */
    @RequestMapping(value = "/search")
    @ResponseBody
    public ModelAndView searchUser(HttpServletRequest request){
        String username = request.getParameter("username");
        ModelAndView modelAndView = new ModelAndView();
        List<User> users = userService.searchUser(username);
        if (!users.isEmpty()){
            //查到了
            modelAndView.addObject("users",users);
        }else {
            //没查到
            modelAndView.addObject("errorName",username);
        }
        modelAndView.setViewName("Main/Home/searchUser");

        return modelAndView;
    }




}
