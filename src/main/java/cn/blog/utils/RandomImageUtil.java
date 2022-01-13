package cn.blog.utils;

import cn.blog.entity.Article;
import cn.blog.entity.add.ArticleWithRandom;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author whai_luo
 * @Date: 2020/7/5 10:53
 */
public class RandomImageUtil {
    /**
     * 生成0到299的随机数 图片一共300张
     * @return
     */
    public static String getImageNum() {
        Random rand = new Random();
        return String.valueOf(rand.nextInt(300));
    }

    public static List<ArticleWithRandom> bindRandomToArticle(List<Article> articles){
        //捆绑随机数
        List<ArticleWithRandom> articleWithRandoms =new ArrayList<>();
        for (Article article : articles) {
            //ArticleWithRandom捆绑上随机数和文章信息
            articleWithRandoms.add(new ArticleWithRandom(article,RandomImageUtil.getImageNum()));
        }
        return articleWithRandoms;
    }

}
