package com.whp.demo.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.whp.dto.demo.DemoDto;

@FeignClient("demo-client")
public interface DemoFeignClient {

	@RequestMapping(value="/selectDemo",method=RequestMethod.GET)
	void selectDemo();
	
	@RequestMapping(value="/getDemo",method=RequestMethod.GET)
	DemoDto getDemo();
}
