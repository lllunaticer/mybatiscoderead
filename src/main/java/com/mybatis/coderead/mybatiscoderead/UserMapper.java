package com.mybatis.coderead.mybatiscoderead;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    List<User> queryUserBySchoolName(User user);
}
