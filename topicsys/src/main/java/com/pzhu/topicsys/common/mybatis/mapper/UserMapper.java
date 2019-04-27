package com.pzhu.topicsys.common.mybatis.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import com.github.pagehelper.Page;
import com.pzhu.topicsys.common.mybatis.entity.User;

public interface UserMapper {
    int deleteByPrimaryKey(String userId);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(String userId);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    /**
     * desc:登录
     * 
     * @param username
     * @param password
     * @return
     */
    User login(@Param("username") String username, @Param("password") String password);

    /**
     * Desc:查询管理员列表
     * 
     * @param name
     * @param rowBounds
     * @return
     */
    Page<User> findManagers(@Param("name") String name, RowBounds rowBounds);

    /**
     * Desc:根据username查User
     * 
     * @param username
     * @return
     */
    User getUserByUsername(@Param("username") String username);
}