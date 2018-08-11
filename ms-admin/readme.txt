1 被监控项目 需要加入依赖
	pom.xml
		<dependency>
			<groupId>org.jolokia</groupId>
			<artifactId>jolokia-core</artifactId>
		</dependency>
2	application.propertites 需要加入
		#关闭安全访问，为了ms-admin工程可以监控
		management.security.enabled=false
		
3  logback.xml 加入
 		<configuration>
			<include resource="org/springframework/boot/logging/logback/base.xml" />
			<jmxConfigurator />
		</configuration>
		
注意事项：
	完成以上步骤，需要刷新项目，在启动		