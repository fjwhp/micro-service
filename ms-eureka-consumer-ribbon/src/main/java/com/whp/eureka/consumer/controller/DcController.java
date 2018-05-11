package com.whp.eureka.consumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class DcController {

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/consumer")
    public String dc() {

        String url = "http://eureka-client/dc";
        System.out.println("调用我==" + url);
        return restTemplate.getForObject(url, String.class);
    }
}
