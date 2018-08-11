package com.whp.controller.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.whp.demo.feign.DemoFeignClient;
import com.whp.dto.demo.DemoDto;

@RestController
public class DemoController {

	@Autowired
	public DemoFeignClient demoFeignClient;
	
	@GetMapping("/selectDemo")
	public void select(){
		demoFeignClient.selectDemo();
	}
	
	@RequestMapping(value="/getDemo",method=RequestMethod.GET)
	public DemoDto getDemo(){
		DemoDto ddDemoDto=new DemoDto();
		ddDemoDto= demoFeignClient.getDemo();
		return ddDemoDto;
	}
}
