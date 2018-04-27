package com.whp.base.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.whp.base.constant.WebConstant;
import com.whp.base.exception.javabean.JsonResult;
import com.whp.base.exception.util.ResultUtils;

/**
 * 
 * @描述：一般异常处理
 *
 * @作者：whp
 * 
 * @时间：2018年3月13日 下午10:39:49
 */
@ControllerAdvice
public class ExceptionHandle {
	private final static Logger logger = LoggerFactory.getLogger(ExceptionHandle.class);

	@ExceptionHandler(value = BusinessCallBackException.class)
	@ResponseBody
	public JsonResult Handle(Exception e) {

		if (e instanceof BusinessCallBackException) {
			BusinessCallBackException exception = (BusinessCallBackException) e;
			return ResultUtils.error(exception.getCode(), exception.getMessage());

		} else {
			// 将系统异常以打印出来
			logger.info("[系统异常]{}", e);
			return ResultUtils.error(WebConstant.WEB_RESULST_JSON_UNKOWN, WebConstant.WEB_RESULST_JSON_UNKOWN_MSG);
		}

	}
}
