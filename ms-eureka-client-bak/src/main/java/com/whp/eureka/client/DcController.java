package com.whp.eureka.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DcController {

    private static Logger logger = LoggerFactory.getLogger(DcController.class);
    @Autowired
    DiscoveryClient discoveryClient;

    @GetMapping("/dc")
    public String dc() {
        String services ="我是备用eureka-client=="+ "Services: " + discoveryClient.getServices();
        logger.info("我是备用eureka-client=="+services);
        return services;
    }

}