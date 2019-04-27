package com.pzhu.topicsys.modules.login.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pzhu.topicsys.common.base.BaseController;
import com.pzhu.topicsys.common.util.JsonResponse;
import com.pzhu.topicsys.modules.login.model.LoginInfo;
import com.pzhu.topicsys.modules.login.service.LoginService;

/**
 * Desc：登录模块Controller
 *
 */
@RestController
public class LoginController extends BaseController {

    @Resource
    private LoginService loginservice;

    @RequestMapping(path = "/login", method = RequestMethod.POST)
    public JsonResponse login(String username, String password) {
        LoginInfo loginInfo = loginservice.login(username, password);
        if (loginInfo != null) {
            return JsonResponse.success(loginInfo);
        } else {
            return JsonResponse.fail("用户名或密码错误");
        }
    }
}
