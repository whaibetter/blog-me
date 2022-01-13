package cn.blog.service.impl;

import cn.blog.entity.Comment;
import cn.blog.mapper.*;
import cn.blog.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author whai_luo
 * @Date: 2020/7/3 14:04
 */
@Service
public class CommentServiceImpl implements CommentService {
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
    public List<Comment> getCommentByArticleId(Integer articleId) {
        return commentMapper.selectCommentByArticleId(articleId);
    }

    @Override
    public int insertComment(Comment comment) {
        return commentMapper.insertSelective(comment);
    }
}
