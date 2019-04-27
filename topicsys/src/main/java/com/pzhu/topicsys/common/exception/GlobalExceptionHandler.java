/**
 * 
 */
package com.pzhu.topicsys.common.exception;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pzhu.topicsys.common.util.JsonResponse;
/**
 * Desc:公共异常Exception Handler
 */
@ControllerAdvice
class GlobalExceptionHandler {

	public static final String DEFAULT_ERROR_VIEW = "error";
	protected Logger logger = LoggerFactory.getLogger(getClass());

	@ExceptionHandler(value = Exception.class)
	@ResponseBody
	public JsonResponse jsonErrorHandler(HttpServletRequest req, Exception e) {
		JsonResponse res = JsonResponse.fail();
		res.setMsg("请求处理发生异常");
		if (e instanceof BusinessException) {
			BusinessException be = (BusinessException) e;
			res.setCode(be.getCode());
			res.setMsg(e.getMessage());
		}
		logger.error("系统异常：", e);

		return res;
	}

}