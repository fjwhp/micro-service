package com.whp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@SpringBootApplication
@ComponentScan(basePackages = {"com.whp"})
public class MybatisApplication {
	protected final static Logger logger = LoggerFactory.getLogger(MybatisApplication.class);
	
	public static void main(String[] args) {
		 SpringApplication app = new SpringApplication(MybatisApplication.class);
	     app.setBannerMode(Banner.Mode.OFF);
	     app.run(args);
	     logger.info("PortalApplication is success!");
	}
	
}
