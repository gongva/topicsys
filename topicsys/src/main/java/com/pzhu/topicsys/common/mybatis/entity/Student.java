package com.pzhu.topicsys.common.mybatis.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.pzhu.topicsys.common.base.Constants;
import com.pzhu.topicsys.common.util.RandUtil;

public class Student {
    private String studentId;

    private String userId;

    private String phone;

    private String departmentId;

    @JsonIgnore()
    private Integer isDelete;

    @JsonIgnore()
    private Date createTime;

    @JsonIgnore()
    private Date updateTime;

    public static Student newStudent() {
    	Student student = new Student();
    	student.setStudentId(RandUtil.uuid());
    	student.setCreateTime(new Date());
    	student.setIsDelete(Constants.IS_DELETE_ENABLE);
    	student.setUpdateTime(new Date());
        return student;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
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