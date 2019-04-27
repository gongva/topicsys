package com.pzhu.topicsys.modules.manager.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pzhu.topicsys.common.base.BaseController;
import com.pzhu.topicsys.common.util.JsonResponse;
import com.pzhu.topicsys.common.util.PageBounds;
import com.pzhu.topicsys.common.util.PageResult;
import com.pzhu.topicsys.modules.manager.service.ManagerService;

/**
 * Desc：管理员管理模块Controller
 *
 */
@RestController
public class ManagerController extends BaseController {

    @Resource
    private ManagerService managerService;

    /**
     * Desc：获取管理员列表
     * 
     * @param type
     * @return
     */
    @RequestMapping(path = "/manager/list", method = RequestMethod.GET)
    public JsonResponse getManagerList(String name, PageBounds page) {
        PageResult result = this.managerService.findManagers(name, page);
        JsonResponse res = JsonResponse.success(result);
        return res;
    }

    /**
     * Desc：管理员新增/修改
     * 
     * @param type
     * @return
     */
    @RequestMapping(path = "/manager/save", method = RequestMethod.POST)
    public JsonResponse save(String userId, String username, String name, String password) {
        boolean result = this.managerService.save(userId, username, name, password);
        if (result) {
            return JsonResponse.success();
        } else {
            return JsonResponse.fail(ApiErrorMsgPost);
        }
    }
}
