package com.pzhu.topicsys.modules.department.service;

import com.pzhu.topicsys.common.util.PageBounds;
import com.pzhu.topicsys.common.util.PageResult;

/**
 * Desc：院系管理Service
 *
 */
public interface DepartmentService {

    /**
     * Desc：查询院系列表
     * 
     * @param name
     * @param page
     * @return
     */
    PageResult findDepartments(String name, PageBounds page);

    /**
     * Desc：新增/修改院系
     * 
     * @param departmentId
     * @param name
     * @return
     */
    boolean save(String departmentId, String name);

    /**
     * Desc：院系停用
     * 
     * @param departmentId
     * @param enable
     * @return
     */
    boolean enable(String departmentId, boolean enable);
}
