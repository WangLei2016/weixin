package com.weixin.dao;

import com.weixin.model.UserBook;

public interface UserBookMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserBook record);

    int insertSelective(UserBook record);

    UserBook selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserBook record);

    int updateByPrimaryKey(UserBook record);
}