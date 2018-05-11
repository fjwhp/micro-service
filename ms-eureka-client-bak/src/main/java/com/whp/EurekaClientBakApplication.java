package com.whp;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 
 * @描述：TODO
 *
 * @作者：wuhp
 * 
 * @时间：2018年5月10日 下午5:01:55
 */
@EnableDiscoveryClient
@SpringBootApplication
public class EurekaClientBakApplication {
    public static void main(String[] args) {
        new SpringApplicationBuilder(EurekaClientBakApplication.class).web(true).run(args);
    }
}