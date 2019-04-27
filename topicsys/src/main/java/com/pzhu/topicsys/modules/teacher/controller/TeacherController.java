package com.pzhu.topicsys.modules.teacher.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pzhu.topicsys.common.base.BaseController;
import com.pzhu.topicsys.common.util.JsonResponse;
import com.pzhu.topicsys.common.util.PageBounds;
import com.pzhu.topicsys.common.util.PageResult;
import com.pzhu.topicsys.modules.teacher.service.TeacherService;

/**
 * Desc：导师管理模块Controller
 *
 */
@RestController
public class TeacherController extends BaseController {

    @Resource
    private TeacherService teacherService;

    /**
     * Desc：获取导师列表
     * 
     * @param name
     * @param page
     * @param size
     * @return
     */
    @RequestMapping(path = "/teacher/list", method = RequestMethod.GET)
    public JsonResponse getTeacherList(String name, PageBounds page) {
        PageResult result = this.teacherService.findTeachers(name, page);
        JsonResponse res = JsonResponse.success(result);
        return res;
    }

    /**
     * Desc：导师新增/修改
     * 
     * @param userId
     * @param username
     * @param name
     * @param departmentId
     * @param jobTitleCode
     * @param phone
     * @param password
     * @return
     */
    @RequestMapping(path = "/teacher/save", method = RequestMethod.POST)
    public JsonResponse save(String userId, String username, String name, String departmentId, String jobTitleCode,
            String phone, String password) {
        boolean result = this.teacherService.save(userId, username, name, departmentId, jobTitleCode, phone, password);
        if (result) {
            return JsonResponse.success();
        } else {
            return JsonResponse.fail(ApiErrorMsgPost);
        }
    }
}
