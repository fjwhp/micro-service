package com.whp.base.exception.util;

import com.whp.base.constant.WebConstant;
import com.whp.base.exception.javabean.JsonResult;

/**
 * 
 * @描述：异常处理工具
 *
 * @作者：wuhp
 * 
 * @时间：2018年3月13日 下午3:04:30
 */
public class ResultUtils {

  /**
   * 
   * @描述：自定义json 成功信息
   *
   * @返回：JsonException
   *
   * @作者：wuhp
   *
   * @时间：2018年3月13日 下午3:28:53
   */
  public static JsonResult success(Object object) {
    JsonResult result = new JsonResult();
    result.setCode(WebConstant.WEB_RESULST_JSON_SUCCESS);
    result.setMsg(WebConstant.WEB_RESULST_JSON_SUCCESS_MSG);
    result.setData(object);
    return result;
  }

  public static JsonResult success() {
    return success(null);
  }

  public static JsonResult error(Integer code, String msg) {
    JsonResult result = new JsonResult();
    result.setCode(code);
    result.setMsg(msg);
    return result;
  }
}
