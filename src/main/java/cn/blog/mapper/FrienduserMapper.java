package cn.blog.mapper;

import cn.blog.entity.Frienduser;

import java.util.List;

public interface FrienduserMapper {
    int deleteByPrimaryKey(Integer userId);

    int deleteFriend(Frienduser frienduser);

    int insertFriend(Frienduser record);

    int insertSelective(Frienduser record);

    Frienduser selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(Frienduser record);

    int updateByPrimaryKey(Frienduser record);

    List<Integer> selectFriendIdByUserId(Integer userId);

    int selectFriendBind(Frienduser frienduser);


}