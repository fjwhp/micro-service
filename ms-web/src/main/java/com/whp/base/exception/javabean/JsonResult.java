package com.whp.base.exception.javabean;
/**
 * 
 * @描述：处理json异常处的异常
 *
 * @作者：wuhp
 * 
 * @时间：2018年3月13日 下午3:03:45
 */
public class JsonResult {

  /** 错误码. */
  private Integer code;

  /** 提示信息. */
  private String msg;

  /** 具体的内容. */
  private Object data;

  public Integer getCode() {
    return code;
  }

  public void setCode(Integer code) {
    this.code = code;
  }

  public String getMsg() {
    return msg;
  }

  public void setMsg(String msg) {
    this.msg = msg;
  }

  public Object getData() {
    return data;
  }

  public void setData(Object data) {
    this.data = data;
  }


}
