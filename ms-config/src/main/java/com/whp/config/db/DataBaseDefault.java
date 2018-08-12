package com.whp.config.db;

import org.springframework.boot.context.properties.ConfigurationProperties;
/**
 * 
 * @描述：单库数据库配置(默认数据库配置)
 *
 * @作者：whp
 * 
 * @时间：2018年8月12日 上午10:22:11
 */
@ConfigurationProperties(prefix = "spring.datasource.default")
public class DataBaseDefault extends DataBaseConfig{

}
