package com.whp.eureka.consumer.feignclient;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

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

    @RequestMapping(value = "/uploadFile", consumes = MediaType.MULTIPART_FORM_DATA_VALUE,method=RequestMethod.POST)
    String handleFileUpload(@RequestPart(value = "file") MultipartFile file);
    
    
}
