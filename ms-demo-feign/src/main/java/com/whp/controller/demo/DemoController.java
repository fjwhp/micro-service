package com.whp.controller.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.whp.demo.feign.DemoFeignClient;

@RestController
public class DemoController {

	@Autowired
	public DemoFeignClient demoFeignClient;
	
	@GetMapping("/select")
	public void select(){
		demoFeignClient.selectDemo();
	}
}
