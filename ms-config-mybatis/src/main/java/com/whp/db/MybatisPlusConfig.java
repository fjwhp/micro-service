package com.whp.db;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.plugin.Interceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.ResourceLoader;

import com.baomidou.mybatisplus.plugins.OptimisticLockerInterceptor;
import com.baomidou.mybatisplus.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.plugins.PerformanceInterceptor;
import com.whp.config.constant.SystemConstant;
import com.whp.config.db.DataBaseDefault;
import com.whp.config.db.multi.MasterDataBaseConfig;
import com.whp.config.db.multi.Slave1DataBaseConfig;

@Configuration
@MapperScan({ "com.whp.mapper.*" })
@EnableConfigurationProperties({  SystemConstant.class })
public class MybatisPlusConfig {

	private SystemConstant systemConstant;

	@Autowired
	private ResourceLoader resourceLoader = new DefaultResourceLoader();
	@Autowired
	private DataBaseDefault dataBaseDefault;
	@Autowired
	private MasterDataBaseConfig masterDataBaseConfig;
	@Autowired
	private Slave1DataBaseConfig slave1DataBaseConfig;
	@Autowired(required = false)
	private Interceptor[] interceptors;

	/**
	 * 
	 * @描述：plus 的性能优化 ,mybatis-plus SQL执行效率插件【生产环境可以关闭】
	 *
	 * @返回：PerformanceInterceptor
	 * 
	 * @作者：whp
	 * 
	 * @时间：2018年8月12日 下午1:12:03
	 */
	public PerformanceInterceptor performanceInterceptor() {
		PerformanceInterceptor performanceInterceptor = new PerformanceInterceptor();
		/* <!-- SQL 执行性能分析，开发环境使用，线上不推荐。 maxTime 指的是 sql 最大执行时长 --> */
		if (systemConstant.isProduceFlag() == true) {
			performanceInterceptor.setMaxTime(1000);
		}
		/* <!--SQL是否格式化 默认false--> */
		performanceInterceptor.setFormat(true);
		return performanceInterceptor;
	}

	/**
	 * 
	 * @描述： mybatis-plus分页插件<br>
	 * 文档：http://mp.baomidou.com<br>
	 *
	 * @返回：PaginationInterceptor
	 * 
	 * @作者：whp
	 * 
	 * @时间：2018年8月12日 下午1:58:54
	 */
	@Bean
	public PaginationInterceptor paginationInterceptor() {
		PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
		// paginationInterceptor.setDialectType("mysql");
		// paginationInterceptor.setLocalPage(true);// 开启 PageHelper 的支持
		return paginationInterceptor;
	}

	@Bean
	public OptimisticLockerInterceptor optimisticLockerInterceptor() {
		OptimisticLockerInterceptor locker = new OptimisticLockerInterceptor();
		return locker;
	}

	

	@Bean
	public DynamicDataSource dynamicDataSource() {
		DynamicDataSource dynamicDataSource = new DynamicDataSource();
		// 候选数据源
		// DynamicDataSource master =
		// DataSourceUtil.getDataSource(masterDataBaseConfig);
		// DynamicDataSource slave1 =
		// DataSourceUtil.getDataSource(databaseBiz001Config);
		Map<Object, Object> map = new HashMap<Object, Object>();
		// map.put("dataSource_default", dataSource_default);
		// map.put("dataSource_biz001", dataSource_biz001);
		dynamicDataSource.setTargetDataSources(map);
		// 默认数据源
		dynamicDataSource.setDefaultTargetDataSource(dataBaseDefault);
		return dynamicDataSource;
	}

}
