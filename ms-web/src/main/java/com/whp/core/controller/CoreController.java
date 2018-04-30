package com.whp.core.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.whp.core.pojo.CoreUser;
import com.whp.core.repository.CoreUserRepository;
@Controller
public class CoreController {

	@Autowired
	CoreUserRepository coreUserRepository;
	
	@RequestMapping("/saveUser")
	public String saveUser(){
		CoreUser user =new CoreUser();
	    user.setUserName("wuhp");
	    user.setIsActive(1);
	    user.setPlatform(1);
	    user.setUpdateTime(new Date());
	    user.setUpdateUserId(1l);
	    user.setUserName("whp");
	    user.setVersion(1);
	    user.setIsDelete("1");
	    coreUserRepository.save(user);
	    return "index";
	}
	@RequestMapping("/index")
	public String index(){
		return "index";
	}
	
}
