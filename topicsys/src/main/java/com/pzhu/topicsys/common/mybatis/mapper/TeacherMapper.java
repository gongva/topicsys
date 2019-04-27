package com.pzhu.topicsys.common.mybatis.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import com.github.pagehelper.Page;
import com.pzhu.topicsys.common.mybatis.entity.Teacher;

public interface TeacherMapper {
    int deleteByPrimaryKey(String teacherId);

    int insert(Teacher record);

    int insertSelective(Teacher record);

    Teacher selectByPrimaryKey(String teacherId);

    int updateByPrimaryKeySelective(Teacher record);

    int updateByPrimaryKey(Teacher record);

    /**
     * Desc:根据UserId获取导师
     * 
     * @param userId
     * @return
     */
    Teacher selectByUserId(@Param("userId") String userId);

    /**
     * Desc:查询导师列表
     * 
     * @param name
     * @param rowBounds
     * @return
     */
    Page<Teacher> findTeachers(@Param("name") String name, RowBounds rowBounds);
}