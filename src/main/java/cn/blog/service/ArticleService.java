package cn.blog.service;

import cn.blog.entity.Article;
import cn.blog.entity.vo.ArticleComHasNameVo;
import cn.blog.entity.vo.ArticleComVo;

import java.util.List;

/**
 * @author whai_luo
 * @Date: 2020/7/3 14:01
 */
public interface ArticleService {

    List<ArticleComVo> getArticlesByUserId(Integer userid);

    int insertArticleSubmit(Article article);

    List<Article> getArticlesTitleByUserId(Integer userid);

    ArticleComHasNameVo getArticleDetailByArticleId(Integer articleId);
}
