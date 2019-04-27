package com.pzhu.topicsys.common.mybatis.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import com.github.pagehelper.Page;
import com.pzhu.topicsys.common.mybatis.entity.Student;

public interface StudentMapper {
	int deleteByPrimaryKey(String studentId);

	int insert(Student record);

	int insertSelective(Student record);

	Student selectByPrimaryKey(String studentId);

	int updateByPrimaryKeySelective(Student record);

	int updateByPrimaryKey(Student record);

	/**
	 * Desc:根据UserId获取学生
	 * 
	 * @param userId
	 * @return
	 */
	Student selectByUserId(@Param("userId") String userId);

	/**
	 * Desc:查询学生列表
	 * 
	 * @param name
	 * @param rowBounds
	 * @return
	 */
	Page<Student> findStudents(@Param("name") String name, RowBounds rowBounds);
}