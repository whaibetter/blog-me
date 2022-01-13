package cn.blog.entity.vo;

import cn.blog.entity.Article;
import cn.blog.entity.Comment;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @author whai_luo
 * @Date: 2020/7/3 17:35
 */
@Data
public class ArticleComVo  {

    Article article;

    List<Comment> comments;

    public ArticleComVo() {
    }

    public ArticleComVo(Article article, List<Comment> comments) {
        this.article = article;
        this.comments = comments;
    }

    @Override
    public String toString() {
        return "ArticleComVo{" +
                "article=" + article +
                ", comments=" + comments +
                '}';
    }
}
