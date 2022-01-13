package cn.blog.entity;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * lookuser
 * @author 
 */
@Data
public class LookUser implements Serializable {
    private Integer userId;

    private Integer lookUserId;

    private Date lookDate;

    private static final long serialVersionUID = 1L;

    public LookUser() {
    }

    public LookUser(Integer userId, Integer lookUserId, Date lookDate) {
        this.userId = userId;
        this.lookUserId = lookUserId;
        this.lookDate = lookDate;
    }
}