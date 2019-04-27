package com.pzhu.topicsys.modules.student.service.impl;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.pzhu.topicsys.common.exception.BusinessException;
import com.pzhu.topicsys.common.mybatis.entity.Student;
import com.pzhu.topicsys.common.mybatis.entity.User;
import com.pzhu.topicsys.common.mybatis.mapper.StudentMapper;
import com.pzhu.topicsys.common.mybatis.mapper.UserMapper;
import com.pzhu.topicsys.common.util.PageBounds;
import com.pzhu.topicsys.common.util.PageResult;
import com.pzhu.topicsys.modules.student.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	@Resource
	private StudentMapper studentMapper;
	@Resource
	private UserMapper userMapper;

	@Override
	public PageResult findStudents(String name, PageBounds page) {
		Page<Student> list = this.studentMapper.findStudents(name, page.toRowBounds());

		PageResult result = new PageResult(page.getPage(), page.getSize(), list);
		return result;
	}

	@Override
	public boolean save(String userId, String username, String name, String departmentId, String phone,
			String password) {
	    if (username == null || name == null || departmentId == null|| phone == null) {
            throw new BusinessException("缺少参数");
        }
		if (userId == null) {
			// 新增
			User userDB = this.userMapper.getUserByUsername(username);
			if (userDB != null) {
				throw new BusinessException(String.format("%s已经存在，不允许重复", username));
			}
			User user = User.newStudent();
			user.setUsername(username);
			user.setName(name);
			user.setPassword(password);

			Student student = Student.newStudent();
			student.setUserId(user.getUserId());
			student.setDepartmentId(departmentId);
			student.setPhone(phone);

			int studentResult = this.studentMapper.insert(student);
			int userResult = this.userMapper.insertSelective(user);
			if (studentResult > 0 && userResult > 0) {
				return true;
			} else {
				throw new BusinessException("新增失败，请与管理员联系");
			}
		} else {
			// 修改
			User user = this.userMapper.selectByPrimaryKey(userId);
			Student student = this.studentMapper.selectByUserId(userId);
			if (user == null || student == null) {
				throw new BusinessException("查无此学生");
			} else {
				user.setName(name);
				user.setUpdateTime(new Date());

				student.setDepartmentId(departmentId);
				student.setPhone(phone);
				student.setUpdateTime(new Date());

				int studentResult = this.studentMapper.updateByPrimaryKeySelective(student);
				int userResult = this.userMapper.updateByPrimaryKeySelective(user);
				if (studentResult > 0 && userResult > 0) {
					return true;
				} else {
					throw new BusinessException("修改失败，请与管理员联系");
				}
			}
		}
	}

}
