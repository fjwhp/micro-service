package com.whp.controller.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.whp.api.demo.ApiDemo;
import com.whp.dto.demo.DemoDto;

/**
 * 
 * @描述：demo 服务提供者 service入口
 *
 * @作者：whp
 * 
 * @时间：2018年8月11日 上午10:52:07
 */
@RestController
public class DemoController {

	@Autowired
	public ApiDemo apiDemo;

	@RequestMapping(value = "/selectDemo", method = RequestMethod.GET)
	public void selectDemo() {
		apiDemo.selectDemo();

	}

	@RequestMapping(value = "/getDemo", method = RequestMethod.GET)
	public DemoDto getDemo() {
		return apiDemo.getDemo();
	}

}
