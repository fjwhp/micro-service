package com.whp.base.constant;

/**
 * 
 * @描述：常量类
 *
 * @作者：wuhp
 * 
 * @时间：2018年3月13日 下午3:05:46
 */
public class WebConstant {

	/**
	 * 常量类，命名规范 。 前缀体现功能模块，后缀体现操作类型和结果。
	 */
	// WEB_RESULST_* 网页返回结果 #################################################
	// start
	/**
	 * 约定 1000 -1999 为系统异常 2000 -2999 为业务异常 以下错误信息，按照错误代码顺序排列 异常代码按照以上规则带入
	 */
	public static int WEB_RESULST_JSON_UNKOWN = -1;
	public static String WEB_RESULST_JSON_UNKOWN_MSG = "系统未知错误";
	public static int WEB_RESULST_JSON_SUCCESS = 10000; // json异步结果正常
	public static String WEB_RESULST_JSON_SUCCESS_MSG = "成功";
	public static int WEB_RESULST_JSON_FAIL = 10001; // json 异步结果错误
	public static String WEB_RESULST_JSON_FAIL_MSG = "失败";

	// WEB_RESULST_* 网页返回结果 ####################################################
	// end

}
