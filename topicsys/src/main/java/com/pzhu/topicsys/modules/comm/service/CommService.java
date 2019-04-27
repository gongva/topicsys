package com.pzhu.topicsys.modules.comm.service;

import java.util.List;

import com.pzhu.topicsys.modules.comm.model.Dict;

/**
 * Desc:公共接口
 *
 */
public interface CommService {

	/**
	 * Desc:获取字典
	 * 
	 * @param type
	 * @return
	 */
	List<Dict> getDict(String type);

	/**
	 * Desc:重置密码
	 * 
	 * @param userId
	 * @return 新密码
	 */
	String resetPwd(String userId);

	/**
	 * Desc:修改密码
	 * 
	 * @param userId
	 * @param oldPassword
	 * @param newPassword
	 * @return
	 */
	boolean updatePwd(String userId, String oldPassword, String newPassword);

	/**
	 * Desc:删除用户
	 * 
	 * @param userId
	 * @return
	 */
	boolean deleteUser(String userId);

	/**
	 * Desc:更改开放时间
	 * 
	 * @param paperTimeStart
	 * @param paperTimeEnd
	 * @return
	 */
	boolean updatePaperTime(String paperTimeStart, String paperTimeEnd);
}
