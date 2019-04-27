package com.pzhu.topicsys.modules.login.service;

import com.pzhu.topicsys.modules.login.model.LoginInfo;

/**
 * Desc：登录Service
 *
 */
public interface LoginService {
    LoginInfo login(String username, String password);
}
