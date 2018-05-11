package com.whp;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 
 * @描述：消费者
 *
 * @作者：whp
 * 
 * @时间：2018年5月10日 下午11:22:41
 */
@EnableDiscoveryClient
@SpringBootApplication
public class EurekaConsumerRibbonApplication {

	public static void main(String[] args) {
		new SpringApplicationBuilder(EurekaConsumerRibbonApplication.class).web(true).run(args);
	}
}
