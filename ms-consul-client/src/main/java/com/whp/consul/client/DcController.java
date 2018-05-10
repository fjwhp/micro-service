package com.whp.consul.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DcController {

    private static Logger logger = LoggerFactory.getLogger(DcController.class);

    @RequestMapping("/home")
    public Object home() {
        System.out.println("1111111111111");
        return "OK11";
    }

}