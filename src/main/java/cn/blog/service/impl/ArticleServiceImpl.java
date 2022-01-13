package cn.blog.service.impl;

import cn.blog.entity.Article;
import cn.blog.entity.Comment;
import cn.blog.entity.User;
import cn.blog.entity.add.CommentWithName;
import cn.blog.entity.vo.ArticleComHasNameVo;
import cn.blog.entity.vo.ArticleComVo;
import cn.blog.mapper.*;
import cn.blog.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author whai_luo
 * @Date: 2020/7/3 14:03
 */
@Service
public class ArticleServiceImpl implements ArticleService {
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
    public List<ArticleComVo> getArticlesByUserId(Integer userId) {
        //先获取文章
        List<Article> articles = articleMapper.selectByUserKey(userId);

        //输出文章携带评论 绑定评论
        List<ArticleComVo> articleComVos = new ArrayList<>();
        for (Article article : articles) {
            //根据文章id获取对应评论
            List<Comment> comments = commentMapper.selectCommentByArticleId(article.getArticleId());
            //绑定评论
            ArticleComVo articleComVo=new ArticleComVo(article,comments);
            articleComVos.add(articleComVo);
        }
        return articleComVos;
    }

    @Override
    public int insertArticleSubmit(Article article) {
        return articleMapper.insertSelective(article);
    }

    @Override
    public List<Article> getArticlesTitleByUserId(Integer userid) {
        return articleMapper.selectArticlesTitleByUserId(userid);
    }

    /**
     *
     * @param articleId
     * @return 文章 评论列表（包含评论者名字）
     */
    @Override
    public ArticleComHasNameVo getArticleDetailByArticleId(Integer articleId) {
        //根据articleid查询具体文章内容
        Article article = articleMapper.selectByPrimaryKey(articleId);
        ArticleComHasNameVo articleComHasNameVo = new ArticleComHasNameVo();
        articleComHasNameVo.setArticle(article);
        //封装评论
        List<CommentWithName> commentWithNames = new ArrayList<>();
        List<Comment> comments = commentMapper.selectCommentByArticleId(articleId);
        for (Comment comment : comments) {
            //评论者id
            Integer commentUserId = comment.getCommentPid();
            //评论者名字获取
            User user = userMapper.selectUserInfo(commentUserId);
            //封装名字和评论
            CommentWithName commentWithName = new CommentWithName(comment.getCommentId(),comment.getCommentPid(),comment.getCommentArticleId(),comment.getCommentContent(),comment.getCommentDate(),user.getUserName());
            commentWithNames.add(commentWithName);
        }
        articleComHasNameVo.setCommentWithName(commentWithNames);
        return articleComHasNameVo;
    }
}
