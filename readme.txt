技术选型说明

1、框架选型 
	后端：springboot 1.5.2.RELEASE，jdk1.8
	前端：thymeleaf
2、架构目录说明
	src/test/java	单元测试
	src/test/resources/	单元测试资源文件
	src/main/resources/：放置资源文件
	src/main/resources/templates ：放置静态页面模板文件
	
3、工程架构采用swagger2的restfull api 风格
	swagger2 优点：（1）前后端分离开发。（2）API文档非常明确	
4、统一异常处理 ：
	自定义异常也区分普通调用和ajax调用，可以区别对待，返回不同的结果。
	4.1当普通调用时，一般跳转到自定义的错误页面。(error.html)
	4.2当ajax调用时，可返回约定的数据对象，方便页面统一处理。

5、工程开发规范，遵从阿里巴巴开发手册，命名一定要规范
6、安全管理：采用 Spring Security
7、数据访问：jpa+hibernate
8、eclipse工程添加 hibernate tool  https://www.cnblogs.com/cc11001100/p/6883795.html
9、数据库缓存采用redis框架， 注意当有使用缓存的时候，要记得update、delete操作要更新缓存
10、在application.properties中配置debug=true，该属性置为true的时候，核心Logger（包含嵌入式容器、hibernate、spring）会输出更多内容，
	但是你自己应用的日志并不会输出为DEBUG级别

参考资料
https://github.com/alibaba/p3c/tree/master/eclipse-plugin 开发规范，插件
http://blog.csdn.net/u011659172/article/details/50800237  数据访问选型	
https://www.cnblogs.com/Renyi-Fan/p/7847217.html mybati和hibernate对比
http://blog.csdn.net/mafan121/article/details/46911017 eclipse连接数据库 hibernate Hql调试
