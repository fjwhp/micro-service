package com.whp.config.constant;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix="ms.config.system.constant")
public class SystemConstant {

	/**
	 * 表示是否生产环境，true是，false否,
	 * 用在一些开发需要，但是线上不需要的场景，比如sql性能分析插件等等
	 */
	private boolean produceFlag;

	
	//################# setter getter ######################################################
	public boolean isProduceFlag() {
		return produceFlag;
	}

	public void setProduceFlag(boolean produceFlag) {
		this.produceFlag = produceFlag;
	}
	
	
}
