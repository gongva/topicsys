package com.pzhu.topicsys.common.mybatis.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.pzhu.topicsys.common.base.Constants;
import com.pzhu.topicsys.common.util.RandUtil;

public class Teacher {
    private String teacherId;

    private String userId;

    private String phone;

    private String jobTitleCode;

    private String departmentId;

    @JsonIgnore()
    private Integer isDelete;

    @JsonIgnore()
    private Date createTime;

    @JsonIgnore()
    private Date updateTime;

    public static Teacher newTeacher() {
    	Teacher teacher = new Teacher();
    	teacher.setTeacherId(RandUtil.uuid());
    	teacher.setCreateTime(new Date());
    	teacher.setIsDelete(Constants.IS_DELETE_ENABLE);
    	teacher.setUpdateTime(new Date());
        return teacher;
    }
    
    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
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

    public String getJobTitleCode() {
        return jobTitleCode;
    }

    public void setJobTitleCode(String jobTitleCode) {
        this.jobTitleCode = jobTitleCode;
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