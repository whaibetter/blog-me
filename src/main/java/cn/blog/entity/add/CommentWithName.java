package cn.blog.entity.add;

import lombok.Data;

import java.util.Date;

/**
 * @author whai_luo
 * @Date: 2020/7/5 17:18
 */
@Data
public class CommentWithName {
    private Integer commentId;

    private Integer commentPid;

    private Integer commentArticleId;

    private String commentContent;

    private Date commentDate;

    private String commentUserName;

    private static final long serialVersionUID = 1L;

    public CommentWithName() {
    }

    public CommentWithName(Integer commentId, Integer commentPid, Integer commentArticleId, String commentContent, Date commentDate, String commentUserName) {
        this.commentId = commentId;
        this.commentPid = commentPid;
        this.commentArticleId = commentArticleId;
        this.commentContent = commentContent;
        this.commentDate = commentDate;
        this.commentUserName = commentUserName;
    }
}
