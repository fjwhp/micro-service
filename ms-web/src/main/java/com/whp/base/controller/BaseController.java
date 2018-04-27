package com.whp.base.controller;

import com.whp.base.constant.WebConstant;
import com.whp.base.exception.javabean.JsonResult;
import com.whp.base.exception.util.ResultUtils;

/**
 * 
 * @描述：基础controller
 *
 * @作者：whp
 * 
 * @时间：2018年3月13日 下午10:21:22
 */
public class BaseController {

	/**
	 * json 请求成功返回结果
	 * 
	 * @return
	 */
	public JsonResult success() {
		return ResultUtils.success();
	}

	/**
	 * 失败返回结果
	 * 
	 * @param msg
	 * @return
	 */
	public JsonResult fail(String msg) {
		return ResultUtils.error(WebConstant.WEB_RESULST_JSON_FAIL, msg);
	}
	/**
	 * 失败返回结果
	 * @param code 必须在webConstant 里描述
	 * @param msg
	 * @return
	 */
	public JsonResult fail(int code, String msg) {
		return ResultUtils.error(code, msg);
	}

}
