package cn.blog.controller;

import cn.blog.entity.Article;
import cn.blog.entity.User;
import cn.blog.entity.add.ArticleWithRandom;
import cn.blog.entity.vo.LookUserVo;
import cn.blog.service.ArticleService;
import cn.blog.service.CommentService;
import cn.blog.service.UserService;
import cn.blog.utils.RandomImageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Random;

/**
 *
 *主页控制器
 * @author whai_luo
 * @Date: 2020/7/3 16:39
 */
@Controller
public class HomeController {

    @Autowired
    ArticleService articleService;

    @Autowired
    CommentService commentService;

    @Autowired
    UserService userService;


    @RequestMapping("/home")
    public ModelAndView index(HttpSession session) throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        User user = (User) session.getAttribute("user");
        //获取全部文章的标题信息
        List<Article> articleInfos = articleService.getArticlesTitleByUserId(user.getUserId());
        //捆绑随机图片
        List<ArticleWithRandom> articleWithRandoms = RandomImageUtil.bindRandomToArticle(articleInfos);


        //获取访问人员记录
        List<LookUserVo> lookMeUser = userService.getlookMeUser(user.getUserId());
        //获取好友信息
        List<User> friendsUser = userService.getFriendUser(user.getUserId());

        session.setAttribute("allLookMeUsers",lookMeUser);
        session.setAttribute("allFriends",friendsUser);
        modelAndView.addObject("allArticleInfos",articleWithRandoms);

        modelAndView.setViewName("Main/Home/intoIndex");
        return modelAndView;
    }

    /**
     * 某个用户的文章库 主页
     * @param userId
     * @return
     * @throws Exception
     */
    @RequestMapping("/userPage/{userId}")
    public ModelAndView userArticlePage(@PathVariable Integer userId) throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        //获取该用户全部文章的标题信息
        List<Article> articleInfos = articleService.getArticlesTitleByUserId(userId);
        //捆绑随机图片
        List<ArticleWithRandom> articleWithRandoms = RandomImageUtil.bindRandomToArticle(articleInfos);

        modelAndView.addObject("allArticleInfos",articleWithRandoms);
        modelAndView.addObject("userInfo",userService.getUser(userId));

        modelAndView.setViewName("Main/Home/intoIndex");
        return modelAndView;
    }

}
