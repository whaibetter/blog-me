package cn.blog.entity;

import java.io.Serializable;
import lombok.Data;

/**
 * frienduser
 * @author 
 */
@Data
public class Frienduser implements Serializable {
    private Integer userId;

    private Integer friendUserid;

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
        Frienduser other = (Frienduser) that;
        return (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getFriendUserid() == null ? other.getFriendUserid() == null : this.getFriendUserid().equals(other.getFriendUserid()));
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", userId=").append(userId);
        sb.append(", friendUserid=").append(friendUserid);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }

    public Frienduser(Integer userId, Integer friendUserid) {
        this.userId = userId;
        this.friendUserid = friendUserid;
    }
}