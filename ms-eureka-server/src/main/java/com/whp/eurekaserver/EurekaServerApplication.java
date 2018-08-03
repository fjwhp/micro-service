package com.whp.eurekaserver;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
/**
 * 
 * @描述：服务注册中心
 *
 * @作者：wuhp
 * 
 * @时间：2018年5月10日 下午5:01:32
 */
@SpringBootApplication
@EnableEurekaServer
@EnableDiscoveryClient
public class EurekaServerApplication {

	public static void main(String[] args) {
		//SpringApplication.run(EurekaServerApplication.class, args);
	    new SpringApplicationBuilder(EurekaServerApplication.class).web(true).run(args);
	}
}
