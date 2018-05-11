package com.whp;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

/**
 * 
 * @描述：消费者
 *
 * @作者：whp
 * 
 * @时间：2018年5月10日 下午11:22:41
 */
@EnableFeignClients //feign是基于ribbon 自带负载均衡
@EnableDiscoveryClient
@SpringBootApplication
public class EurekaConsumerFeignApplication {

	public static void main(String[] args) {
		new SpringApplicationBuilder(EurekaConsumerFeignApplication.class).web(true).run(args);
	}
}
