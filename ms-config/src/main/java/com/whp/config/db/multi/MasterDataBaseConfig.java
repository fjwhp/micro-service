package com.whp.config.db.multi;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import com.whp.config.db.DataBaseConfig;
/**
 * 
 * @描述：多数据库  主库
 *
 * @作者：whp
 * 
 * @时间：2018年8月12日 上午10:25:45
 */
@ConfigurationProperties(prefix = "spring.datasource.multi.master")
public class MasterDataBaseConfig extends DataBaseConfig{

}
