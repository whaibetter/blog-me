package cn.blog.controller;

import cn.blog.entity.Article;
import cn.blog.entity.Comment;
import cn.blog.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * @author whai_luo
 * @Date: 2020/7/3 21:40
 */
@RequestMapping("/comment")
@Controller
public class CommentController {

    @Autowired
    CommentService commentService;

    //添加评论
    @RequestMapping(value = "/insert")
    @ResponseBody
    public void insertComment(Comment comment) throws Exception {
        //添加评论
        comment.setCommentDate(new Date());
        commentService.insertComment(comment);
    }
}
