package com.whp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * 
 * @描述：web服务主程序
 *
 * @作者：wuhp
 * 
 * @时间：2018年3月13日 下午1:10:47
 */
/**
 * 开启缓存
 */
@EnableCaching
@SpringBootApplication
@EnableAsync
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
