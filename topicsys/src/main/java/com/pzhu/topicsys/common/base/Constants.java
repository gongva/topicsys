package com.pzhu.topicsys.common.base;

/**
 * Desc:静态常量集合
 *
 */
public class Constants {

	// 重置密码时的初始密码
	public static final String DEFAULT_PASSWORD = "123456";

	// 角色code
	public static final String ROLE_CODE_ADMIN = "role_admin";
	public static final String ROLE_CODE_MANAGER = "role_m";
	public static final String ROLE_CODE_TEACHER = "role_t";
	public static final String ROLE_CODE_STUDENT = "role_s";

	// is_delete的状态枚举
	public static final int IS_DELETE_ENABLE = 0;// 可用
	public static final int IS_DELETE_UNENABLE = 8;// 停用
	public static final int IS_DELETE_DELETED = 9;// 删除

	// 开放时间code
	public static final String PAPER_TIME_START = "paper_time_start";
	public static final String PAPER_TIME_END = "paper_time_end";

	// 课题状态
	public static final int TOPIC_STATUS_TO_SIGN = 1;//可选报
	public static final int TOPIC_STATUS_TO_UPLOAD = 2;//待提交
	public static final int TOPIC_STATUS_TO_VALIDATE = 3;//待审核
	public static final int TOPIC_STATUS_VALIDATE_PASS = 4;//审核通过
	public static final int TOPIC_STATUS_VALIDATE_REJECT = 5;//审核不通过
}
