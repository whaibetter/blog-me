package cn.blog.service;

import cn.blog.entity.Comment;

import java.util.List;

/**
 * @author whai_luo
 * @Date: 2020/7/3 14:04
 */
public interface CommentService {

    List<Comment> getCommentByArticleId(Integer articleId);

    int insertComment(Comment comment);
}
