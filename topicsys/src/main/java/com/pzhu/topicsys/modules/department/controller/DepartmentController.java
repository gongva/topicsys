package com.pzhu.topicsys.modules.department.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pzhu.topicsys.common.base.BaseController;
import com.pzhu.topicsys.common.util.JsonResponse;
import com.pzhu.topicsys.common.util.PageBounds;
import com.pzhu.topicsys.common.util.PageResult;
import com.pzhu.topicsys.modules.department.service.DepartmentService;

/**
 * Desc：院系管理模块Controller
 *
 */
@RestController
public class DepartmentController extends BaseController {

    @Resource
    private DepartmentService departmentService;

    /**
     * Desc：获取院系列表
     * 
     * @param name
     * @param page
     * @param size
     * @return
     */
    @RequestMapping(path = "/department/list", method = RequestMethod.GET)
    public JsonResponse getDepartmentList(String name, PageBounds page) {
        PageResult result = this.departmentService.findDepartments(name, page);
        JsonResponse res = JsonResponse.success(result);
        return res;
    }

    /**
     * Desc：院系新增/修改
     * 
     * @param departmentId
     * @param name
     * @return
     */
    @RequestMapping(path = "/departmen/save", method = RequestMethod.POST)
    public JsonResponse save(String departmentId, String name) {
        boolean result = this.departmentService.save(departmentId, name);
        if (result) {
            return JsonResponse.success();
        } else {
            return JsonResponse.fail(ApiErrorMsgPost);
        }
    }

    /**
     * Desc：院系新增/修改
     * 
     * @param departmentId
     * @param enable
     * @return
     */
    @RequestMapping(path = "/departmen/enable", method = RequestMethod.POST)
    public JsonResponse unEnable(String departmentId, boolean enable) {
        boolean result = departmentService.enable(departmentId, enable);
        if (result) {
            return JsonResponse.success();
        } else {
            return JsonResponse.fail(ApiErrorMsgPost);
        }
    }
}
