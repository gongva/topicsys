package com.pzhu.topicsys.common.mybatis.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Department {
    private String departmentId;

    private String departmentName;

    @JsonIgnore()
    private Integer isDelete;

    @JsonIgnore()
    private Date createTime;

    @JsonIgnore()
    private Date updateTime;

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
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