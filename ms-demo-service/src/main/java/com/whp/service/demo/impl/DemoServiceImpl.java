package com.whp.service.demo.impl;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.whp.api.demo.ApiDemo;
@RestController
@Service
public class DemoServiceImpl implements ApiDemo{

	@GetMapping("/selectDemo")
	@Override
	public void selectDemo() {
		System.out.println("DemoServiceImpl  实现类====在这里实现业务逻辑");
		
	}

}
