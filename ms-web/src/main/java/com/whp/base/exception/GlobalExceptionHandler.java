package com.whp.base.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**
 * 
 * @描述：统一异常处理
 *
 * @作者：wuhp
 * 
 * @时间：2018年3月13日 下午1:27:09
 */
@ControllerAdvice
class GlobalExceptionHandler {

  public static final String DEFAULT_ERROR_VIEW = "/error";

  @ExceptionHandler(value = Exception.class)
  public ModelAndView defaultErrorHandler(HttpServletRequest req, Exception e) throws Exception {
    ModelAndView mav = new ModelAndView();
    mav.addObject("exception", e);
    mav.addObject("url", req.getRequestURL());
    mav.setViewName(DEFAULT_ERROR_VIEW);
    return mav;
  }

}
