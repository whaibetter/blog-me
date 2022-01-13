package cn.blog.mapper;

import cn.blog.entity.LookUser;

import java.util.List;

public interface LookuserMapper {
    int insert(LookUser record);

    int insertSelective(LookUser record);

    List<LookUser> selectLookMeUser(Integer userId);
}