package com.pzhu.topicsys.common.mybatis.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import com.github.pagehelper.Page;
import com.pzhu.topicsys.common.mybatis.entity.Department;

public interface DepartmentMapper {
    int deleteByPrimaryKey(String departmentId);

    int insert(Department record);

    int insertSelective(Department record);

    Department selectByPrimaryKey(String departmentId);

    int updateByPrimaryKeySelective(Department record);

    int updateByPrimaryKey(Department record);

    /**
     * Desc:查询院系列表
     * 
     * @param name
     * @param rowBounds
     * @return
     */
    Page<Department> findDepartments(@Param("name") String name, RowBounds rowBounds);

    /**
     * Desc:根据department_name查Department
     * 
     * @param name
     * @return
     */
    Department getDepartmentByName(@Param("name") String name);
}