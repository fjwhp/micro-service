package com.whp;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@EnableFeignClients //feign是基于ribbon 自带负载均衡
@EnableDiscoveryClient
@SpringBootApplication
public class DemoFeignApplication {
	public static void main(String[] args) {
		new SpringApplicationBuilder(DemoFeignApplication.class).web(true).run(args);
	}
}
