package com.pzhu.topicsys.modules.teacher.service.impl;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.pzhu.topicsys.common.exception.BusinessException;
import com.pzhu.topicsys.common.mybatis.entity.Teacher;
import com.pzhu.topicsys.common.mybatis.entity.User;
import com.pzhu.topicsys.common.mybatis.mapper.TeacherMapper;
import com.pzhu.topicsys.common.mybatis.mapper.UserMapper;
import com.pzhu.topicsys.common.util.PageBounds;
import com.pzhu.topicsys.common.util.PageResult;
import com.pzhu.topicsys.modules.teacher.service.TeacherService;

@Service
public class TeacherServiceImpl implements TeacherService {

	@Resource
	private TeacherMapper teacherMapper;
	@Resource
	private UserMapper userMapper;

	@Override
	public PageResult findTeachers(String name, PageBounds page) {
		Page<Teacher> list = this.teacherMapper.findTeachers(name, page.toRowBounds());

		PageResult result = new PageResult(page.getPage(), page.getSize(), list);
		return result;
	}

	@Override
	public boolean save(String userId, String username, String name, String departmentId, String jobTitleCode,
			String phone, String password) {
	    if (username == null || name == null || departmentId == null|| jobTitleCode == null || phone == null) {
            throw new BusinessException("缺少参数");
        }
		if (userId == null) {
			// 新增
			User userDB = this.userMapper.getUserByUsername(username);
			if (userDB != null) {
				throw new BusinessException(String.format("%s已经存在，不允许重复", username));
			}
			User user = User.newTeacher();
			user.setUsername(username);
			user.setName(name);
			user.setPassword(password);

			Teacher teacher = Teacher.newTeacher();
			teacher.setUserId(user.getUserId());
			teacher.setDepartmentId(departmentId);
			teacher.setJobTitleCode(jobTitleCode);
			teacher.setPhone(phone);

			int teacherResult = this.teacherMapper.insert(teacher);
			int userResult = this.userMapper.insertSelective(user);
			if (teacherResult > 0 && userResult > 0) {
				return true;
			} else {
				throw new BusinessException("新增失败，请与管理员联系");
			}
		} else {
			// 修改
			User user = this.userMapper.selectByPrimaryKey(userId);
			Teacher teacher = this.teacherMapper.selectByUserId(userId);
			if (user == null || teacher == null) {
				throw new BusinessException("查无此导师");
			} else {
				user.setName(name);
				user.setUpdateTime(new Date());

				teacher.setDepartmentId(departmentId);
				teacher.setJobTitleCode(jobTitleCode);
				teacher.setPhone(phone);
				teacher.setUpdateTime(new Date());

				int teacherResult = this.teacherMapper.updateByPrimaryKeySelective(teacher);
				int userResult = this.userMapper.updateByPrimaryKeySelective(user);
				if (teacherResult > 0 && userResult > 0) {
					return true;
				} else {
					throw new BusinessException("修改失败，请与管理员联系");
				}
			}
		}
	}

}
