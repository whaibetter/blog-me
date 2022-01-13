package cn.blog.entity;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * comment
 * @author 
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Comment implements Serializable {
    private Integer commentId;

    private Integer commentPid;

    private Integer commentArticleId;

    private String commentContent;

    private Date commentDate;

    private static final long serialVersionUID = 1L;

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
        Comment other = (Comment) that;
        return (this.getCommentId() == null ? other.getCommentId() == null : this.getCommentId().equals(other.getCommentId()))
            && (this.getCommentPid() == null ? other.getCommentPid() == null : this.getCommentPid().equals(other.getCommentPid()))
            && (this.getCommentArticleId() == null ? other.getCommentArticleId() == null : this.getCommentArticleId().equals(other.getCommentArticleId()))
            && (this.getCommentContent() == null ? other.getCommentContent() == null : this.getCommentContent().equals(other.getCommentContent()))
            && (this.getCommentDate() == null ? other.getCommentDate() == null : this.getCommentDate().equals(other.getCommentDate()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getCommentId() == null) ? 0 : getCommentId().hashCode());
        result = prime * result + ((getCommentPid() == null) ? 0 : getCommentPid().hashCode());
        result = prime * result + ((getCommentArticleId() == null) ? 0 : getCommentArticleId().hashCode());
        result = prime * result + ((getCommentContent() == null) ? 0 : getCommentContent().hashCode());
        result = prime * result + ((getCommentDate() == null) ? 0 : getCommentDate().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", commentId=").append(commentId);
        sb.append(", commentPid=").append(commentPid);
        sb.append(", commentArticleId=").append(commentArticleId);
        sb.append(", commentContent=").append(commentContent);
        sb.append(", commentDate=").append(commentDate);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}