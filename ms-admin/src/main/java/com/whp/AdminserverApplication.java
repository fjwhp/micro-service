package com.whp;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import de.codecentric.boot.admin.config.EnableAdminServer;
@EnableDiscoveryClient
@EnableAdminServer
@SpringBootApplication
public class AdminserverApplication {

	public static void main(String[] args) {
		new SpringApplicationBuilder(AdminserverApplication.class).web(true).run(args);
	}
}
