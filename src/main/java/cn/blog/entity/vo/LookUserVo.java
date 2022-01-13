package cn.blog.entity.vo;

import cn.blog.entity.User;
import lombok.Data;

import java.util.Date;

/**
 * @author whai_luo
 * @Date: 2020/7/3 19:33
 */
@Data
public class LookUserVo {

    private User user;
    private Date lookDate;

    public LookUserVo(User user, Date lookDate) {
        this.user = user;
        this.lookDate = lookDate;
    }

    @Override
    public String toString() {
        return "LookUserVo{" +
                "user=" + user +
                ", lookDate=" + lookDate +
                '}';
    }
}
