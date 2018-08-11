package com.whp.service.demo.impl;

import org.springframework.stereotype.Service;

import com.whp.api.demo.ApiDemo;
import com.whp.dto.demo.DemoDto;
@Service
public class DemoServiceImpl implements ApiDemo{

	
	@Override
	public void selectDemo() {
		System.out.println("DemoServiceImpl  实现类====在这里实现业务逻辑");
		
	}

	@Override
	public DemoDto getDemo() {
		DemoDto tDemoDto =new DemoDto();
		tDemoDto.setEmail("13213.com");
		tDemoDto.setUserName("whp");
		System.out.println("getdemo请求====");
		return tDemoDto;
	}

}
