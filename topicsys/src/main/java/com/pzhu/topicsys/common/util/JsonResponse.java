package com.pzhu.topicsys.common.util;

import java.io.Serializable;

/**
 * Desc:返回格式构建
 *
 */
public class JsonResponse implements Serializable {

	private static final long serialVersionUID = 9087410717667408519L;

	public static String DEFAULT_SUCCESS_MESSAGE = "操作成功";
	public static String DEFAULT_FAIL_MESSAGE = "操作失败";

	private Boolean success;// 请求是否成功
	private Integer code;// 状态，0为成，其他为各种异常情况
	private Object data;// 返回数据
	private String msg;// 状态消息

	public JsonResponse() {
	}

	public JsonResponse(Boolean success, Integer code, String msg) {
		super();
		this.success = success;
		this.code = code;
		this.msg = msg;
	}
	
	public JsonResponse(Boolean success, Integer code, String msg, Object data) {
	    super();
	    this.success = success;
	    this.code = code;
	    this.msg = msg;
	    this.data = data;
	}

	public static JsonResponse success() {
		return new JsonResponse(true, 200, DEFAULT_SUCCESS_MESSAGE);
	}

	public static JsonResponse success(Object data) {
        return new JsonResponse(true, 200, DEFAULT_SUCCESS_MESSAGE, data);
	}

	public static JsonResponse fail() {
        return new JsonResponse(false, 500, DEFAULT_FAIL_MESSAGE);
	}

	public static JsonResponse fail(String message) {
        return new JsonResponse(false, 500, message);
	}
	
	public static JsonResponse fail(int code, String message) {
		return new JsonResponse(false, code, message);
	}

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }


}
