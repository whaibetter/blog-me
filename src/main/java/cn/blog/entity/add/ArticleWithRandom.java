package cn.blog.entity.add;

import cn.blog.entity.Article;
import lombok.Data;

/**
 * @author whai_luo
 * @Date: 2020/7/5 11:18
 */
@Data
public class ArticleWithRandom {
    private Article article;
    private String randomImage;

    public ArticleWithRandom(Article article,String randomImage) {
        this.article = article;
        this.randomImage = randomImage;
    }
}
