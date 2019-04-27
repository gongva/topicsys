package com.pzhu.topicsys.modules.comm.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pzhu.topicsys.common.base.BaseController;
import com.pzhu.topicsys.common.util.JsonResponse;
import com.pzhu.topicsys.modules.comm.model.Dict;
import com.pzhu.topicsys.modules.comm.model.NoticeEntity;
import com.pzhu.topicsys.modules.comm.service.CommService;

/**
 * Desc：公共模块Controller
 *
 */
@RestController
public class CommController extends BaseController {

    @Resource
    private CommService commService;

    /**
     * Desc：获取字典
     * 
     * @param type
     * @return
     */
    @RequestMapping(path = "/sys/dict", method = RequestMethod.GET)
    public JsonResponse getDict(String type) {
        List<Dict> dicts = this.commService.getDict(type);
        if (dicts != null) {
            return JsonResponse.success(dicts);
        } else {
            return JsonResponse.fail(ApiErrorMsgGet);
        }
    }

    /**
     * Desc：重置密码
     * 
     * @param type
     * @return
     */
    @RequestMapping(path = "/user/pwd/reset", method = RequestMethod.POST)
    public JsonResponse resetPwd(String userId) {
        String newPwd = this.commService.resetPwd(userId);
        return JsonResponse.success(new NoticeEntity(String.format("密码已重置为%s", newPwd)));
    }

    /**
     * Desc:修改密码
     * 
     * @param userId
     * @param oldPassword
     * @param newPassword
     * @return
     */
    @RequestMapping(path = "/user/pwd/update", method = RequestMethod.POST)
    public JsonResponse updatePwd(String userId, String oldPassword, String newPassword) {
        boolean result = this.commService.updatePwd(userId, oldPassword, newPassword);
        if (result) {
            return JsonResponse.success();
        } else {
            return JsonResponse.fail(ApiErrorMsgPost);
        }
    }

    /**
     * Desc:删除用户
     * 
     * @param userId
     * @return
     */
    @RequestMapping(path = "/user/delete", method = RequestMethod.POST)
    public JsonResponse deleteUser(String userId) {
        boolean result = this.commService.deleteUser(userId);
        if (result) {
            return JsonResponse.success();
        } else {
            return JsonResponse.fail(ApiErrorMsgPost);
        }
    }

    /**
     * Desc:更新开放时间
     * 
     * @param paperTimeStart
     * @param paperTimeEnd
     * @return
     */
    @RequestMapping(path = "/sys/paperTime/update", method = RequestMethod.POST)
    public JsonResponse updatePaperTime(String paperTimeStart, String paperTimeEnd) {
        boolean result = this.commService.updatePaperTime(paperTimeStart, paperTimeEnd);
        if (result) {
            return JsonResponse.success();
        } else {
            return JsonResponse.fail(ApiErrorMsgPost);
        }
    }
}
