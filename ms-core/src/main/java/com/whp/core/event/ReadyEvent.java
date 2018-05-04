package com.whp.core.event;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;

/**
 * 
 * @描述：项目启动完毕[事件]
 *
 * @作者：wuhp
 * 
 * @时间：2018年5月3日 下午2:25:39
 */
public class ReadyEvent implements ApplicationListener<ApplicationReadyEvent> {

    private final static Logger logger = LoggerFactory.getLogger(ReadyEvent.class);

    @Override
    public void onApplicationEvent(ApplicationReadyEvent e) {
        logger.info("\n项目启动完毕[事件]：ReadyEvent");
        /**
         * 系统启动完毕可以加载必须的事件
         *
         */
    }

}
