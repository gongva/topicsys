package com.pzhu.topicsys.modules.teacher.service;

import com.pzhu.topicsys.common.util.PageBounds;
import com.pzhu.topicsys.common.util.PageResult;

/**
 * Desc：导师管理Service
 *
 */
public interface TeacherService {

	/**
	 * Desc：查询导师列表
	 * 
	 * @param name
	 * @param page
	 * @return
	 */
	PageResult findTeachers(String name, PageBounds page);

	/**
	 * Desc：新增/修改导师
	 * 
	 * @param userId
	 * @param username
	 * @param name
	 * @param departmentId
	 * @param department
	 * @param jobTitleCode
	 * @param jobTitle
	 * @param phone
	 * @param password
	 * @return
	 */
	boolean save(String userId, String username, String name, String departmentId, String jobTitleCode, String phone,
			String password);

}
