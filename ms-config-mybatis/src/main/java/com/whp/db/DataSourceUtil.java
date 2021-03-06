package com.whp.db;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.druid.pool.DruidDataSource;
import com.whp.config.db.DataBaseConfig;


/**
 * 
 * @描述：数据源工具类
 *
 * @作者：whp
 *
 * @时间：2017年6月16日 下午9:39:51
 */
public class DataSourceUtil {
  private final static Logger logger = LoggerFactory.getLogger(DataSourceUtil.class);
  /**
   * 
   * @描述：根据配置类获取数据源
   *
   * @返回：DataSource
   *
   * @作者：whp
   *
   * @时间：2017年6月16日 下午9:40:09
   */
  public static DataSource getDataSource(DataBaseConfig db) {
    DruidDataSource ds = new DruidDataSource();
    /**
     * 基本属性 type、driverClass、url、user、password
     */
    ds.setDbType(db.getDbType());
    ds.setDriverClassName(db.getDriverClassName());
    ds.setUrl(db.getUrl());
    ds.setUsername(db.getUsername());
    ds.setPassword(db.getPassword());
    /**
     * 配置初始化大小、最小、最大
     */
    ds.setInitialSize(db.getInitialSize());
    ds.setMinIdle(db.getMinIdle());
    ds.setMaxActive(db.getMaxActive());
    /**
     * 配置获取连接等待超时的时间
     */
    ds.setMaxWait(db.getMaxWait());
    /**
     * 配置间隔多久才进行一次检测，检测需要关闭的空闲连接，单位是毫秒
     */
    ds.setTimeBetweenEvictionRunsMillis(db.getTimeBetweenEvictionRunsMillis());
    /**
     * 配置一个连接在池中最小生存的时间，单位是毫秒
     */
    ds.setMinEvictableIdleTimeMillis(db.getMinEvictableIdleTimeMillis());

    ds.setValidationQuery(db.getValidationQuery());
    ds.setTestWhileIdle(db.isTestWhileIdle());
    ds.setTestOnBorrow(db.isTestOnBorrow());
    ds.setTestOnReturn(db.isTestOnReturn());

    /**
     * 打开PSCache，并且指定每个连接上PSCache的大小
     */
    ds.setPoolPreparedStatements(db.isPoolPreparedStatements());
    ds.setMaxPoolPreparedStatementPerConnectionSize(
        db.getMaxPoolPreparedStatementPerConnectionSize());
    /**
     * 配置监控统计拦截的filters
     */
    try {
      ds.setFilters(db.getFilters());
    } catch (SQLException e) {
      logger.error("",e);
    }
    ds.setConnectionProperties(db.getConnectionProperties());
    return ds;
  }
}
