package cn.blog.entity.vo;

import cn.blog.entity.Article;
import cn.blog.entity.Comment;
import cn.blog.entity.add.CommentWithName;
import lombok.Data;

import java.util.List;

/**
 * @author whai_luo
 * @Date: 2020/7/5 17:23
 */
@Data
public class ArticleComHasNameVo {
    Article article;

    List<CommentWithName> CommentWithName;

    public ArticleComHasNameVo() {
    }

    public ArticleComHasNameVo(Article article, List<CommentWithName> CommentWithName) {
        this.article = article;
        this.CommentWithName = CommentWithName;
    }
}
