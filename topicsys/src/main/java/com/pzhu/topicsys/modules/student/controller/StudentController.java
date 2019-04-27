package com.pzhu.topicsys.modules.student.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pzhu.topicsys.common.base.BaseController;
import com.pzhu.topicsys.common.util.JsonResponse;
import com.pzhu.topicsys.common.util.PageBounds;
import com.pzhu.topicsys.common.util.PageResult;
import com.pzhu.topicsys.modules.student.service.StudentService;

/**
 * Desc：学生管理模块Controller
 *
 */
@RestController
public class StudentController extends BaseController {

    @Resource
    private StudentService studentService;

    /**
     * Desc：获取学生列表
     * 
     * @param name
     * @param page
     * @param size
     * @return
     */
    @RequestMapping(path = "/student/list", method = RequestMethod.GET)
    public JsonResponse getStudentList(String name, PageBounds page) {
        PageResult result = this.studentService.findStudents(name, page);
        JsonResponse res = JsonResponse.success(result);
        return res;
    }

    /**
     * Desc：学生新增/修改
     * 
     * @param userId
     * @param username
     * @param name
     * @param departmentId
     * @param phone
     * @param password
     * @return
     */
    @RequestMapping(path = "/student/save", method = RequestMethod.POST)
    public JsonResponse save(String userId, String username, String name, String departmentId, String phone,
            String password) {
        boolean result = this.studentService.save(userId, username, name, departmentId, phone, password);
        if (result) {
            return JsonResponse.success();
        } else {
            return JsonResponse.fail(ApiErrorMsgPost);
        }
    }
}
