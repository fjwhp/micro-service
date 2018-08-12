package com.whp.db;

/**
 * 
 * @描述：数据源枚举
 *
 * @作者：zhongjy
 *
 * @时间：2017年6月16日 下午9:13:43
 */
public enum DBTypeEnum {
	/**
	 * 默认数据源(单库)
	 */
	DATASOURCE_DEFAULT("dataSource_default"),
	/**
	 * 多数据源   mater 主库
	 */
	DATASOURCE_MASTER("datasource_master"),
	/**
	 * 多数据源   slave1  从库
	 */
	DATASOURCE_SLAVE1("datasource_slave1");

	private String value;

	DBTypeEnum(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
}
