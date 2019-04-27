package com.pzhu.topicsys.modules.login.model;

/**
 * 登录接口返回
 *
 */
public class LoginInfo {

    private String userId;
    private String roleCode;
    private String username;
    private String name;
    private String departmentId;
    private String department;
    private String phone;
    private String jobTitleCode;// 导师属性
    private String jobTitle;// 导师属性
    private boolean hasSignTopic;// 是否已选报课题，学生属性

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
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

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public boolean isHasSignTopic() {
        return hasSignTopic;
    }

    public void setHasSignTopic(boolean hasSignTopic) {
        this.hasSignTopic = hasSignTopic;
    }

}
