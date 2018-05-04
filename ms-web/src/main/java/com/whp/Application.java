package com.whp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.annotation.EnableAsync;

import com.whp.core.event.EnvironmentPreparedEvent;
import com.whp.core.event.PreparedEvent;
import com.whp.core.event.ReadyEvent;
import com.whp.utils.SpringContextUtil;

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
        SpringApplication application = new SpringApplication(Application.class);
        // 环境已经准备完毕，上下文还没有创建[事件]
        application.addListeners(new EnvironmentPreparedEvent());
        // 上下文创建完成[事件]
        application.addListeners(new PreparedEvent());
        // 项目启动完毕[事件]
        application.addListeners(new ReadyEvent());
        // 启动
        ApplicationContext context = application.run(args);
        // 设置上下文到SpringContextUtil
        SpringContextUtil.setApplicationContext(context);
    }
}
