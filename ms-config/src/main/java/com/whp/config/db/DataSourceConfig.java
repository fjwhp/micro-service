package com.whp.config.db;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * 
 * @描述：多数据源配置
 *
 * @作者：wuhp
 * 
 * @时间：2018年3月14日 下午5:29:42
 */
@Configuration
public class DataSourceConfig {

  /**
   * 
   * @描述：默认第一个数据源
   *
   * @返回：DataSource
   *
   * @作者：wuhp
   *
   * @时间：2018年3月14日 下午5:30:02
   */
  @Bean(name = "primaryDataSource")
  @Qualifier("primaryDataSource")
  @ConfigurationProperties(prefix = "spring.datasource.primary")
  public DataSource primaryDataSource() {
    return DataSourceBuilder.create().build();
    
  }
  /**
   * 
   * @描述：可选第二个数据源
   *
   * @返回：DataSource
   *
   * @作者：wuhp
   *
   * @时间：2018年3月14日 下午5:30:30
   */
  @Bean(name = "secondaryDataSource")
  @Qualifier("secondaryDataSource")
  @Primary
  @ConfigurationProperties(prefix = "spring.datasource.secondary")
  public DataSource secondaryDataSource() {
    return DataSourceBuilder.create().build();
  }

}
