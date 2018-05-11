package com.whp.eureka.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
/**
 * 
 * @描述：restfull 负载均衡请求
 *
 * @作者：wuhp
 * 
 * @时间：2018年5月11日 上午9:19:13
 */
@Configuration
public class Config {

	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
