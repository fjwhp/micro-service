package com.whp.db;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * 
 * @描述：动态数据源
 *
 * @作者：whp
 * 
 * @时间：2018年8月12日 下午1:37:35
 */
public class DynamicDataSource extends AbstractRoutingDataSource {
	/**
	 * 取得当前使用哪个数据源
	 */
	@Override
	protected Object determineCurrentLookupKey() {
		return DbContextHolder.getDbType();
	}

}
