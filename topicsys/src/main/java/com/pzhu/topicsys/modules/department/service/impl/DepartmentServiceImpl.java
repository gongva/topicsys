package com.pzhu.topicsys.modules.department.service.impl;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.pzhu.topicsys.common.base.Constants;
import com.pzhu.topicsys.common.exception.BusinessException;
import com.pzhu.topicsys.common.mybatis.entity.Department;
import com.pzhu.topicsys.common.mybatis.mapper.DepartmentMapper;
import com.pzhu.topicsys.common.util.PageBounds;
import com.pzhu.topicsys.common.util.PageResult;
import com.pzhu.topicsys.common.util.RandUtil;
import com.pzhu.topicsys.modules.department.service.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Resource
    private DepartmentMapper departmentMapper;
    
    @Override
    public PageResult findDepartments(String name, PageBounds page) {
        Page<Department> list = this.departmentMapper.findDepartments(name, page.toRowBounds());

        PageResult result = new PageResult(page.getPage(), page.getSize(), list);
        return result;
    }

    @Override
    public boolean save(String departmentId, String name) {
        if (name == null) {
            throw new BusinessException("缺少参数");
        }
        Department departmentTemp = this.departmentMapper.getDepartmentByName(name);
        if (departmentTemp != null) {
            throw new BusinessException(String.format("%s已经存在，不允许重复", name));
        }
        if (departmentId == null) {
        	//新增
            Department department = new Department();
            department.setDepartmentId(RandUtil.uuid());
            department.setCreateTime(new Date());
            department.setDepartmentName(name);
            department.setIsDelete(0);
            department.setUpdateTime(new Date());
            int lines = this.departmentMapper.insertSelective(department);
            return lines > 0;
        } else {
        	//修改
            Department departmentDB = this.departmentMapper.selectByPrimaryKey(departmentId);
            if (departmentDB == null) {
                throw new BusinessException("查无此院系");
            } else {
                departmentDB.setDepartmentName(name);
                departmentDB.setUpdateTime(new Date());
                int lines = this.departmentMapper.updateByPrimaryKeySelective(departmentDB);
                return lines > 0;
            }
        }
    }

    @Override
    public boolean enable(String departmentId, boolean enable) {
    	Department departmentDB = this.departmentMapper.selectByPrimaryKey(departmentId);
        if (departmentDB == null) {
            throw new BusinessException("查无此院系");
        } else {
        	departmentDB.setIsDelete(enable?Constants.IS_DELETE_ENABLE : Constants.IS_DELETE_UNENABLE);
            int lines = this.departmentMapper.updateByPrimaryKeySelective(departmentDB);
            return lines > 0;
        }
    }

}
