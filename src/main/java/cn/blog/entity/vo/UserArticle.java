package cn.blog.entity.vo;

import cn.blog.entity.Article;
import cn.blog.entity.User;
import lombok.Data;

import java.util.List;

/**
 * @author whai_luo
 * @Date: 2020/7/4 9:57
 */
@Data
public class UserArticle {

    private User user;
    private List<Article> articles;

    public UserArticle(User user, List<Article> articles) {
        this.user = user;
        this.articles = articles;
    }

    public UserArticle() {
    }
}
