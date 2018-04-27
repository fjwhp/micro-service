package com.whp.demo.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.catalina.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/swagger")
public class SwaggerController {

  static Map<Long, User> users = Collections.synchronizedMap(new HashMap<Long, User>()); 
  @SuppressWarnings("unchecked")
  @ApiOperation(value="获取用户列表", notes="")
  @RequestMapping(value={""}, method=RequestMethod.GET)
  public List<User> getUserList() {
    @SuppressWarnings("rawtypes")
    List listUser= new ArrayList<>();
      for (int i = 0; i <5; i++) {
         listUser.add(i, "whp");
      }
      return listUser;
  }
}
