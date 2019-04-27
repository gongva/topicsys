package com.pzhu.topicsys.modules.comm.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.pzhu.topicsys.common.base.Constants;
import com.pzhu.topicsys.common.exception.BusinessException;
import com.pzhu.topicsys.common.mybatis.entity.SystemConfig;
import com.pzhu.topicsys.common.mybatis.entity.User;
import com.pzhu.topicsys.common.mybatis.mapper.SystemConfigMapper;
import com.pzhu.topicsys.common.mybatis.mapper.UserMapper;
import com.pzhu.topicsys.common.util.MD5;
import com.pzhu.topicsys.modules.comm.model.Dict;
import com.pzhu.topicsys.modules.comm.service.CommService;

@Service
public class CommServiceImpl implements CommService {

    @Resource
    private SystemConfigMapper systemConfigMapper;
    @Resource
    private UserMapper userMapper;

    @Override
    public List<Dict> getDict(String type) {
        if (type == null) {
            throw new BusinessException("缺少参数");
        }
        List<Dict> dicts = this.systemConfigMapper.getDict(type);
        return dicts;
    }

    @Override
    public String resetPwd(String userId) {
        if (userId == null) {
            throw new BusinessException("缺少参数");
        }
        User user = this.userMapper.selectByPrimaryKey(userId);
        if (user == null) {
            throw new BusinessException("查无此用户");
        } else {
            user.setPassword(MD5.md5(Constants.DEFAULT_PASSWORD));
            user.setUpdateTime(new Date());

            int result = this.userMapper.updateByPrimaryKeySelective(user);
            if (result > 0) {
                return Constants.DEFAULT_PASSWORD;
            } else {
                throw new BusinessException("密码重置失败，请与管理员联系");
            }
        }
    }

    @Override
    public boolean updatePwd(String userId, String oldPassword, String newPassword) {
        if (userId == null || oldPassword == null || newPassword == null) {
            throw new BusinessException("缺少参数");
        }
        User user = this.userMapper.selectByPrimaryKey(userId);
        if (user == null) {
            throw new BusinessException("查无此用户");
        } else if (!user.getPassword().equals(oldPassword)) {
            throw new BusinessException("旧密码错误");
        } else {
            user.setPassword(newPassword);
            user.setUpdateTime(new Date());

            int result = this.userMapper.updateByPrimaryKeySelective(user);
            return result > 0;
        }
    }

    @Override
    public boolean deleteUser(String userId) {
        if (userId == null) {
            throw new BusinessException("缺少参数");
        }
        User user = this.userMapper.selectByPrimaryKey(userId);
        if (user == null) {
            throw new BusinessException("查无此用户");
        } else {
            user.setIsDelete(Constants.IS_DELETE_DELETED);
            user.setUpdateTime(new Date());

            int result = this.userMapper.updateByPrimaryKeySelective(user);
            return result > 0;
        }
    }

    @Override
    public boolean updatePaperTime(String paperTimeStart, String paperTimeEnd) {
        if (paperTimeStart == null || paperTimeEnd == null) {
            throw new BusinessException("缺少参数");
        }
        SystemConfig startConfig = this.systemConfigMapper.selectByCode(Constants.PAPER_TIME_START);
        SystemConfig endConfig = this.systemConfigMapper.selectByCode(Constants.PAPER_TIME_END);
        if (startConfig != null && endConfig != null) {
            startConfig.setValue(paperTimeStart);
            endConfig.setValue(paperTimeEnd);

            int resultStart = this.systemConfigMapper.updateByPrimaryKeySelective(startConfig);
            int resultEnd = this.systemConfigMapper.updateByPrimaryKeySelective(endConfig);

            if (resultStart > 0 && resultEnd > 0) {
                return true;
            } else {
                throw new BusinessException("保存失败，请联系系统管理员");
            }
        } else {
            throw new BusinessException("系统配置未初始化开放时间，请联系系统管理员");
        }
    }
}
