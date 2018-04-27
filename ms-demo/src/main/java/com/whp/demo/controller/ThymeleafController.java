package com.whp.demo.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class ThymeleafController {

  @RequestMapping("/aa")
  public String index(Map<String, Object> map) {
   /* map.put(key, value)
      map.addAttribute("host", "http://blog.didispace.com");*/
      return "base/index";
  }
}
