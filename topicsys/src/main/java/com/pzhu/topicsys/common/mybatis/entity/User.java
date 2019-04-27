package com.pzhu.topicsys.common.mybatis.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.pzhu.topicsys.common.base.Constants;
import com.pzhu.topicsys.common.util.RandUtil;

public class User {
    private String userId;

    private String username;

    @JsonIgnore()
    private String password;

    private String name;

    private String role;

    @JsonIgnore()
    private Integer isDelete;

    @JsonIgnore()
    private Date createTime;

    @JsonIgnore()
    private Date updateTime;

    public static User newManager() {
        User user = new User();
        user.setUserId(RandUtil.uuid());
        user.setCreateTime(new Date());
        user.setIsDelete(Constants.IS_DELETE_ENABLE);
        user.setRole(Constants.ROLE_CODE_MANAGER);
        user.setUpdateTime(new Date());
        return user;
    }

    public static User newTeacher() {
        User user = new User();
        user.setUserId(RandUtil.uuid());
        user.setCreateTime(new Date());
        user.setIsDelete(Constants.IS_DELETE_ENABLE);
        user.setRole(Constants.ROLE_CODE_TEACHER);
        user.setUpdateTime(new Date());
        return user;
    }

    public static User newStudent() {
        User user = new User();
        user.setUserId(RandUtil.uuid());
        user.setCreateTime(new Date());
        user.setIsDelete(Constants.IS_DELETE_ENABLE);
        user.setRole(Constants.ROLE_CODE_STUDENT);
        user.setUpdateTime(new Date());
        return user;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}