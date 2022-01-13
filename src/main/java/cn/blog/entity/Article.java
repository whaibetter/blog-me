package cn.blog.entity;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * article
 * @author 
 */
@Data
public class Article implements Serializable {
    private Integer articleId;

    private Integer articleUserId;

    private String articleTitle;

    private String articleContent;

    private Date articleDate;

    private static final long serialVersionUID = 1L;

    public Article(Integer articleId, Integer articleUserId, String articleTitle, String articleContent, Date articleDate) {
        this.articleId = articleId;
        this.articleUserId = articleUserId;
        this.articleTitle = articleTitle;
        this.articleContent = articleContent;
        this.articleDate = articleDate;
    }

    public Article() {
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Article other = (Article) that;
        return (this.getArticleId() == null ? other.getArticleId() == null : this.getArticleId().equals(other.getArticleId()))
            && (this.getArticleUserId() == null ? other.getArticleUserId() == null : this.getArticleUserId().equals(other.getArticleUserId()))
            && (this.getArticleTitle() == null ? other.getArticleTitle() == null : this.getArticleTitle().equals(other.getArticleTitle()))
            && (this.getArticleContent() == null ? other.getArticleContent() == null : this.getArticleContent().equals(other.getArticleContent()))
            && (this.getArticleDate() == null ? other.getArticleDate() == null : this.getArticleDate().equals(other.getArticleDate()));
    }

//    @Override
//    public int hashCode() {
//        final int prime = 31;
//        int result = 1;
//        result = prime * result + ((getArticleId() == null) ? 0 : getArticleId().hashCode());
//        result = prime * result + ((getArticleUserId() == null) ? 0 : getArticleUserId().hashCode());
//        result = prime * result + ((getArticleTitle() == null) ? 0 : getArticleTitle().hashCode());
//        result = prime * result + ((getArticleContent() == null) ? 0 : getArticleContent().hashCode());
//        result = prime * result + ((getArticleDate() == null) ? 0 : getArticleDate().hashCode());
//        return result;
//    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", articleId=").append(articleId);
        sb.append(", articleUserId=").append(articleUserId);
        sb.append(", articleTitle=").append(articleTitle);
        sb.append(", articleContent=").append(articleContent);
        sb.append(", articleDate=").append(articleDate);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}