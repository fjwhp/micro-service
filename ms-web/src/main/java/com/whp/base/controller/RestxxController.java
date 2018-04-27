package com.whp.base.controller;

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
/**
 * 
 * @描述：restfull api 例子，web接口 必须满足以下例子
 *
 * @作者：whp
 * 
 * @时间：2018年3月13日 下午10:45:17
 */
@RestController
@RequestMapping("/rest")
public class RestxxController extends BaseController{

  static Map<Long, User> users = Collections.synchronizedMap(new HashMap<Long, User>()); 
  @SuppressWarnings("unchecked")
  @ApiOperation(value="获取用户列表", notes="")
  @RequestMapping(value={"/getUser"}, method=RequestMethod.GET)
  public List<User> getUserList() {
    @SuppressWarnings("rawtypes")
    List listUser= new ArrayList<>();
      for (int i = 0; i <5; i++) {
         listUser.add(i, "whp");
      }
     
      return listUser;
  }
  
 
  
 
}
