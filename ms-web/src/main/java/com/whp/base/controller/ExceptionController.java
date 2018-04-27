package com.whp.base.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.whp.base.exception.BusinessCallBackException;

@RestController
@RequestMapping("/exce")
public class ExceptionController {

	@RequestMapping("/callback")
	public void getBusException() {
		throw new BusinessCallBackException("测试定义异常");
	}
}
