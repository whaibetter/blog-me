package cn.blog.mapper;

import cn.blog.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {
    int deleteByPrimaryKey(Integer userId);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    User loginVerify(User user);

    User selectUserInfo(Integer userId);

    List<User> searchUser(String username);

    User usernameVerify(String username);
}