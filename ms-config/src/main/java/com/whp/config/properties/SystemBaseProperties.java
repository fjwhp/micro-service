package com.whp.config.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 
 * @描述：可以在 application.properties 配置相关的系统参数， 以这个 ms.config.system为前缀
 *
 * @作者：wuhp
 * 
 * @时间：2018年3月14日 下午5:39:31
 */
@Component
@ConfigurationProperties(prefix = "ms.config.systembaseproperties")
public class SystemBaseProperties {

  /**
   * 系统参数保留，需要的时候在加入
   */
   private String projectName;

   //##############################################  setter  getter
   
   public String getProjectName() {
     return projectName;
   }

   public void setProjectName(String projectName) {
     this.projectName = projectName;
   }
   
}
