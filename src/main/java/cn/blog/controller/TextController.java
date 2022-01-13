package cn.blog.controller;

import cn.blog.entity.Frienduser;
import cn.blog.service.ArticleService;
import cn.blog.service.CommentService;
import cn.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @author whai_luo
 * @Date: 2020/7/3 16:06
 */
@Controller
public class TextController {

    @Autowired
    ArticleService articleService;

    @Autowired
    CommentService commentService;

    @Autowired
    UserService userService;


    @RequestMapping(value = "/text",produces="application/json;charset=UTF-8")
    @ResponseBody
    public String text(HttpServletRequest request){
        /*//获取全部文章
        List<ArticleComVo> articleComVos = articleService.getArticlesByUserId(1);
        //获取访问人员记录
        List<LookUserVo> lookMeUser = userService.getlookMeUser(1);
        //获取好友信息
        List<User> friendsUser = userService.getFriendUser(1);


        Map<String,String> map = new HashMap<>();
        map.put("aaa", String.valueOf(friendsUser));
        map.put("avv","w我是是随时随地撒多");
        return JSONObject.toJSONString(map);*/

        return String.valueOf(userService.findFrinedBind(new Frienduser(2,3)));
    }
}
