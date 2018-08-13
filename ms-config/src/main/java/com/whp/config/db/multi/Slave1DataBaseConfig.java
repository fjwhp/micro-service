package com.whp.config.db.multi;

import org.springframework.boot.context.properties.ConfigurationProperties;

import com.whp.config.db.DataBaseConfig;
/**
 * 
 * @描述：多数据库  从库
 *
 * @作者：whp
 * 
 * @时间：2018年8月12日 上午10:25:12
 */
@ConfigurationProperties(prefix = "spring.datasource.multi.slave1")
public class Slave1DataBaseConfig extends DataBaseConfig{

}
