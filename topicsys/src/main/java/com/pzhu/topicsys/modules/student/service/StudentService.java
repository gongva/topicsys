package com.pzhu.topicsys.modules.student.service;

import com.pzhu.topicsys.common.util.PageBounds;
import com.pzhu.topicsys.common.util.PageResult;

/**
 * Desc：学生管理Service
 *
 */
public interface StudentService {

	/**
	 * Desc：查询学生列表
	 * 
	 * @param name
	 * @param page
	 * @return
	 */
	PageResult findStudents(String name, PageBounds page);

	/**
	 * Desc：新增/修改学生
	 * 
	 * @param userId
	 * @param username
	 * @param name
	 * @param departmentId
	 * @param phone
	 * @param password
	 * @return
	 */
	boolean save(String userId, String username, String name, String departmentId, String phone, String password);

}
