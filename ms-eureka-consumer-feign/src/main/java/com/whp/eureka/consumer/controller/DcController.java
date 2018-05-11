package com.whp.eureka.consumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.whp.eureka.consumer.feignclient.EurekaClientInterface;

@RestController
public class DcController {

    @Autowired
    EurekaClientInterface eurekaClientInterface;

    /**
     * 
     * @描述：
     *
     * @返回：String
     *
     * @作者：wuhp
     *
     * @时间：2018年5月11日 上午11:23:12
     */
    //@RequestMapping(method = RequestMethod.GET,value = "/dc") 
    @GetMapping("/dc")
    public String dc() {

        return eurekaClientInterface.consumer();
    }

}
