在Spring Cloud Config中通过在属性值前使用{cipher}前缀来标注该内容是一个加密值，当微服务客户端来加载配置时，配置中心会自动的为带有{cipher}前缀的值进行解密。通过该机制的实现，运维团队就可以放心的将线上信息的加密资源给到微服务团队，而不用担心这些敏感信息遭到泄露了。
我们需要将local_policy.jar和US_export_policy.jar两个文件复制到$JAVA_HOME/jre/lib/security目录下，覆盖原来的默认内容。到这里，加密解密的准备工作就完成了。

如果安装了JRE，将两个jar文件放到%JRE_HOME%\lib\security目录下覆盖原来的文件
如果安装了JDK，还要将两个jar文件也放到%JDK_HOME%\jre\lib\security目录下覆盖原来文件。