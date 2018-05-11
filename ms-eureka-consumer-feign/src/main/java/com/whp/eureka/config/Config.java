package com.whp.eureka.config;

import org.springframework.cloud.netflix.feign.support.SpringMvcContract;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import feign.Contract;
import feign.Logger;
import feign.auth.BasicAuthRequestInterceptor;

@Configuration
public class Config {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public Contract feignContract() {
        return new SpringMvcContract();
    }

    @Bean
    public Logger.Level logLevel() {
        return Logger.Level.FULL;
    }

    @Bean

    public BasicAuthRequestInterceptor getBasicAuthRequestInterceptor() {

        return new BasicAuthRequestInterceptor("gwolf", "gwolf");

    }
}
