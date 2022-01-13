package cn.blog.controller;

import cn.blog.entity.Article;
import cn.blog.entity.LookUser;
import cn.blog.entity.User;
import cn.blog.entity.vo.ArticleComHasNameVo;
import cn.blog.service.ArticleService;
import cn.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;



import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 * @author whai_luo
 * @Date: 2020/7/3 21:21
 */
@Controller
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    ArticleService articleService;

    @Autowired
    UserService UserService;

    @RequestMapping("/toCreateArticle")
    public  String toInsert(){
        return "/Main/Home/insert";
    }

    /**
     *后台添加文章提交操作
     * @param article 包含文本内容 文本标题
     * @return
     * @throws Exception
     */

    @RequestMapping(value = "/insertArticleSubmit",method = RequestMethod.POST)
    public String insertArticleSubmit(Article article,HttpSession session) throws Exception {

        article.setArticleDate(new Date());
        User user = (User) session.getAttribute("user");
        article.setArticleUserId(user.getUserId());
        articleService.insertArticleSubmit(article);

        return "redirect:/home";
    }


    /**
     *  //文章详情页显示
     *
     *  通过articleDetailVo.Article访问文章内容
     *      articleDetailVo.Comment访问文章评论信息
     * @param articleId
     * @return ArticleComVo articleDetailWithComment
     * @throws Exception
     */
    @RequestMapping(value = "/articleDetail/{articleId}")
    @ResponseBody //适合RESTful
    public ModelAndView ArticleDetail(@PathVariable Integer articleId, HttpSession session){
        ModelAndView modelAndView = new ModelAndView();

        //文章信息 作者 评论
        ArticleComHasNameVo articleDetailWithComment = articleService.getArticleDetailByArticleId(articleId);
        if(articleDetailWithComment!=null) {
            User user = (User) session.getAttribute("user");
            //读者id
            Integer lookUserId = user.getUserId();
            //文章作者id
            Integer articleUserId = articleDetailWithComment.getArticle().getArticleUserId();
            //添加围观记录 我访问我的文章不添加记录
            if (!articleUserId.equals(user.getUserId())){
                UserService.addLookMeUser(new LookUser(articleUserId,lookUserId,new Date()));
            }
            modelAndView.addObject("articleDetailWithComment", articleDetailWithComment);
            modelAndView.setViewName("Main/Home/articleDetail");
        } else {
            modelAndView.setViewName("Main/404");
        }
        return modelAndView;
        //不会被解析为跳转路径，而是直接写入HTTP response body中

    }
}
