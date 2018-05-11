package com.whp.eureka.consumer.feignclient;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 
 * @描述：指定这个接口所要调用的服务名称
 *
 * @作者：wuhp
 * 
 * @时间：2018年5月11日 上午9:41:54
 */
@FeignClient("eureka-client")
public interface EurekaClientInterface {

    /**
     * 
     * @描述：绑定eureka-client服务的/dc接口
     *
     * @返回：String
     *
     * @作者：wuhp
     *
     * @时间：2018年5月11日 上午9:43:08
     */
    @RequestMapping(method = RequestMethod.GET,value = "/dc")
    String consumer();

    
}
