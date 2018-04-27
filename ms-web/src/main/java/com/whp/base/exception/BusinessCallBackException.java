package com.whp.base.exception;

import com.whp.base.constant.WebConstant;

/**
 * 
 * @描述：系统业务异常  ，抛出此异常，restfull api 将得到jsonResult 格式的 错误信息
 *
 * @作者：whp
 * 
 * @时间：2018年3月13日 下午10:27:47
 */
public class BusinessCallBackException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1305418420615374825L;
	private Integer code;

	public BusinessCallBackException(Integer code, String message) {
		super(message);
		this.code = code;
	}
	
	public BusinessCallBackException( String message) {
		super(message);
		this.code = WebConstant.WEB_RESULST_JSON_FAIL;
	} 

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

}
