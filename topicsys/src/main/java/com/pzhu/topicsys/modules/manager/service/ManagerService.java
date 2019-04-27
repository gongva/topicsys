package com.pzhu.topicsys.modules.manager.service;

import com.pzhu.topicsys.common.util.PageBounds;
import com.pzhu.topicsys.common.util.PageResult;

/**
 * Desc：管理员管理Service
 *
 */
public interface ManagerService {

    /**
     * Desc：查询管理员列表
     * 
     * @param name
     * @param page
     * @return
     */
    PageResult findManagers(String name, PageBounds page);

    /**
     * Desc：新增/修改管理员
     * 
     * @param userId
     * @param username
     * @param name
     * @param password
     * @return
     */
    boolean save(String userId, String username, String name, String password);
}
