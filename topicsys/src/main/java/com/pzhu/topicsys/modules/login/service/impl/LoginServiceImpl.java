package com.pzhu.topicsys.modules.login.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.pzhu.topicsys.common.base.Constants;
import com.pzhu.topicsys.common.exception.BusinessException;
import com.pzhu.topicsys.common.mybatis.entity.Department;
import com.pzhu.topicsys.common.mybatis.entity.Student;
import com.pzhu.topicsys.common.mybatis.entity.Teacher;
import com.pzhu.topicsys.common.mybatis.entity.Topic;
import com.pzhu.topicsys.common.mybatis.entity.User;
import com.pzhu.topicsys.common.mybatis.mapper.DepartmentMapper;
import com.pzhu.topicsys.common.mybatis.mapper.StudentMapper;
import com.pzhu.topicsys.common.mybatis.mapper.SystemConfigMapper;
import com.pzhu.topicsys.common.mybatis.mapper.TeacherMapper;
import com.pzhu.topicsys.common.mybatis.mapper.TopicMapper;
import com.pzhu.topicsys.common.mybatis.mapper.UserMapper;
import com.pzhu.topicsys.modules.login.model.LoginInfo;
import com.pzhu.topicsys.modules.login.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService {

    @Resource
    private UserMapper userMapper;
    @Resource
    private TeacherMapper teacherMapper;
    @Resource
    private StudentMapper studentMapper;
    @Resource
    private TopicMapper topicMapper;
    @Resource
    private DepartmentMapper departmentMapper;
    @Resource
    private SystemConfigMapper systemConfigMapper;

    @Override
    public LoginInfo login(String username, String password) {
        if (username == null || password == null) {
            throw new BusinessException("缺少参数");
        }
        LoginInfo loginInfo = null;
        User user = userMapper.login(username, password);
        if (user != null) {
            loginInfo = new LoginInfo();
            loginInfo.setUserId(user.getUserId());
            loginInfo.setName(user.getName());
            loginInfo.setRoleCode(user.getRole());
            loginInfo.setUsername(user.getUsername());
            switch (user.getRole()) {
            case Constants.ROLE_CODE_ADMIN:
            case Constants.ROLE_CODE_MANAGER:
                // 没有多余信息了
                break;
            case Constants.ROLE_CODE_TEACHER:
                // 根据userid查老师附属信息
                Teacher teacher = teacherMapper.selectByUserId(user.getUserId());
                loginInfo.setPhone(teacher.getPhone());
                loginInfo.setDepartmentId(teacher.getDepartmentId());
                loginInfo.setJobTitleCode(teacher.getJobTitleCode());
                
                Department tDepartment = departmentMapper.selectByPrimaryKey(teacher.getDepartmentId());
                loginInfo.setDepartment(tDepartment.getDepartmentName());
                
                String jobTitle = systemConfigMapper.getValueByCode(teacher.getJobTitleCode());
                loginInfo.setJobTitle(jobTitle);
                break;
            case Constants.ROLE_CODE_STUDENT:
                // 根据userid查学生附属信息
                Student student = studentMapper.selectByUserId(user.getUserId());
                loginInfo.setPhone(student.getPhone());
                loginInfo.setDepartmentId(student.getDepartmentId());
                
                Department sDepartment = departmentMapper.selectByPrimaryKey(student.getDepartmentId());
                loginInfo.setDepartment(sDepartment.getDepartmentName());
                
                Topic topic = topicMapper.selectByUserId(user.getUserId());
                loginInfo.setHasSignTopic(topic != null);
                break;
            }
        }
        return loginInfo;
    }

}
