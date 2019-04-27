package com.pzhu.topicsys.modules.manager.service.impl;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.pzhu.topicsys.common.exception.BusinessException;
import com.pzhu.topicsys.common.mybatis.entity.User;
import com.pzhu.topicsys.common.mybatis.mapper.UserMapper;
import com.pzhu.topicsys.common.util.PageBounds;
import com.pzhu.topicsys.common.util.PageResult;
import com.pzhu.topicsys.modules.manager.service.ManagerService;

@Service
public class ManagerServiceImpl implements ManagerService {

    @Resource
    private UserMapper userMapper;

    @Override
    public PageResult findManagers(String name, PageBounds page) {
        Page<User> list = this.userMapper.findManagers(name, page.toRowBounds());

        PageResult result = new PageResult(page.getPage(), page.getSize(), list);
        return result;
    }

    @Override
    public boolean save(String userId, String username, String name, String password) {
        if (username == null || name == null) {
            throw new BusinessException("缺少参数");
        }
        if (userId == null) {
        	//新增
            User userDB = this.userMapper.getUserByUsername(username);
            if (userDB != null) {
                throw new BusinessException(String.format("%s已经存在，不允许重复", username));
            }
            User user = User.newManager();
            user.setUsername(username);
            user.setName(name);
            user.setPassword(password);
            int lines = this.userMapper.insertSelective(user);
            return lines > 0;
        } else {
        	//修改
            User userDB = this.userMapper.selectByPrimaryKey(userId);
            if (userDB == null) {
                throw new BusinessException("查无此用户");
            } else {
                userDB.setUsername(username);
                userDB.setName(name);
                userDB.setUpdateTime(new Date());
                int lines = this.userMapper.updateByPrimaryKeySelective(userDB);
                return lines > 0;
            }
        }
    }
}
