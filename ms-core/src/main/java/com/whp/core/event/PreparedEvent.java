package com.whp.core.event;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationPreparedEvent;
import org.springframework.context.ApplicationListener;

/**
 * 
 * @描述：上下文创建完成[事件]
 *
 * @作者：wuhp
 * 
 * @时间：2018年5月3日 下午2:25:51
 */
public class PreparedEvent implements ApplicationListener<ApplicationPreparedEvent> {

	private final static Logger logger = LoggerFactory.getLogger(PreparedEvent.class);

	@Override
	public void onApplicationEvent(ApplicationPreparedEvent e) {
		logger.info("\n上下文创建完成[事件]：PreparedEvent");
	}

}
