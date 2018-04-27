package com.whp.config.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 
 * @描述：线程池配置
 *
 * @作者：wuhp
 * 
 * @时间：2018年3月16日 下午6:11:44
 */
@ConfigurationProperties(prefix="com.whp.config.properties.threadPoolConfig")
public class TaskThreadPoolConfig {

  /**
   * 核心线程池大小
   */
  private Integer corePoolSize;
  /**
   * 最大线程池大小
   */
  private Integer maxPoolSize;
  /**
   * 线程持续存活时间(秒)
   */
  private Integer keepAliveSeconds;
  /**
   * 队列容量
   */
  private Integer queueCapacity;
  
  //###########################setter getter

  public Integer getCorePoolSize() {
      return corePoolSize;
  }

  public void setCorePoolSize(Integer corePoolSize) {
      this.corePoolSize = corePoolSize;
  }

  public Integer getMaxPoolSize() {
      return maxPoolSize;
  }

  public void setMaxPoolSize(Integer maxPoolSize) {
      this.maxPoolSize = maxPoolSize;
  }

  public Integer getKeepAliveSeconds() {
      return keepAliveSeconds;
  }

  public void setKeepAliveSeconds(Integer keepAliveSeconds) {
      this.keepAliveSeconds = keepAliveSeconds;
  }

  public Integer getQueueCapacity() {
      return queueCapacity;
  }

  public void setQueueCapacity(Integer queueCapacity) {
      this.queueCapacity = queueCapacity;
  }
}
