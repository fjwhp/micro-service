package com.whp.coder;

import java.io.File;
import java.nio.file.Files;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.TemplateConfig;
import com.baomidou.mybatisplus.generator.config.rules.DbType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

/**
 * 
 * @描述：mybatisplus代码生成器
 *
 * @作者：wuhp
 * 
 * @时间：2018年4月27日 下午2:56:20
 */
public class MpGenerator {
	public static final String PATH = "E:/developer/coder";
	public static final String userName = "root";
	public static final String pwd = "whp@123";
	public static final String db_ip = "192.168.10.101";
	public static final String database = "ms-cloud";

	public static void makeCode() {
		// 模块名
		String moduleName = "demo";
		// 表名
		String[] tableName = new String[] { "demo_user"};
		// String[] tableName = new String[] { "aut_user" };
		AutoGenerator mpg = new AutoGenerator();
		// 全局配置
		GlobalConfig gc = new GlobalConfig();
		final String codePath = PATH;
		gc.setOutputDir(codePath);// 代码生成路径
		gc.setFileOverride(true);
		gc.setActiveRecord(true);
		gc.setEnableCache(false);// XML 二级缓存
		gc.setBaseResultMap(true);// XML ResultMap
		gc.setBaseColumnList(true);// XML columList
		gc.setOpen(true);
		gc.setAuthor("whp");
		// 自定义文件命名，注意 %s 会自动填充表实体属性！
		// gc.setMapperName("%sDao");
		// gc.setXmlName("%sDao");
		gc.setServiceName("%sService");
		// gc.setServiceImplName("%sServiceDiy");
		// gc.setControllerName("%sAction");
		gc.setActiveRecord(false);// 不生成实体pkVal()方法
		mpg.setGlobalConfig(gc);

		// 数据源配置
		DataSourceConfig dsc = new DataSourceConfig();
		dsc.setDbType(DbType.MYSQL);
		dsc.setDriverName("com.mysql.jdbc.Driver");
		dsc.setUsername(userName);
		dsc.setPassword("whp@123");
		dsc.setUrl("jdbc:mysql://" + db_ip + ":3306/" + database + "?characterEncoding=utf8");
		mpg.setDataSource(dsc);

		// 策略配置(自定义，源代码有缺陷，重写里面的一个方法)
		// StrategyConfig strategy = new StrategyConfig();
		CustomStrategyConfig strategy = new CustomStrategyConfig();
		// strategy.setCapitalMode(true);// 全局大写命名 ORACLE 注意
		strategy.setNaming(NamingStrategy.underline_to_camel);// 表名生成策略
		strategy.setDbColumnUnderline(true);
		strategy.setInclude(tableName); // 需要生成的表
		// strategy.setExclude(new String[] { "aut_remember_me" }); // 排除生成的表
		// 自定义实体父类
		strategy.setSuperEntityClass("com.whp.base.entity.SuperEntity");
		// 自定义实体，公共字段
		strategy.setSuperEntityColumns(new String[] { "sid", "create_by", "create_time", "update_by", "update_time",
				"version", "delete_status", });
		// 自定义 mapper 父类
		// strategy.setSuperMapperClass("com.baomidou.demo.TestMapper");
		// 自定义 service 父类
		// strategy.setSuperServiceClass("com.baomidou.demo.TestService");
		// 自定义 service 实现类父类
		// strategy.setSuperServiceImplClass("com.baomidou.demo.TestServiceImpl");
		// 自定义 controller 父类
		strategy.setSuperControllerClass("com.whp.base.controller.BaseController");
		// 【实体】是否生成字段常量（默认 false）
		// strategy.setEntityColumnConstant(true);
		// 【实体】是否为构建者模型（默认 false）
		// public User setName(String name) {this.name = name; return this;}
		strategy.setEntityBuilderModel(true);
		mpg.setStrategy(strategy);

		// 包配置
		PackageConfig pc = new PackageConfig();
		pc.setParent("com.whp");

		pc.setController("web.controller");
		pc.setEntity("entity");
		pc.setMapper("dao.mapper");
		pc.setXml("dao.mapper.xml");
		pc.setModuleName(moduleName);
		pc.setService("iservice");
		pc.setServiceImpl("service");

		mpg.setPackageInfo(pc);

		// 自定义模板配置(如果设置null则不生成该模块)
		TemplateConfig tc = new TemplateConfig();
		tc.setController("whp_coder_template/controller.java.vm");
		tc.setEntity("whp_coder_template/entity.java.vm");
		tc.setMapper("whp_coder_template/mapper.java.vm");
		tc.setXml("whp_coder_template/mapper.xml.vm");
		tc.setService("whp_coder_template/service.java.vm");
		tc.setServiceImpl("whp_coder_template/serviceImpl.java.vm");

		mpg.setTemplate(tc);

		// 执行生成
		mpg.execute();
	}

	public static void main(String[] args) throws Exception {
		makeCode();
		// Thread.sleep(3000);
		deleteFile();
		File file = new File(PATH);
		copyFile(file);

	}

	public static void deleteFile() {
		File controller = new File(PATH + "/controller");
		File entity = new File(PATH + "/entity");
		File mapper = new File(PATH + "/mapper");
		File service = new File(PATH + "/service");
		deleteDir(controller);
		deleteDir(entity);
		deleteDir(mapper);
		deleteDir(service);
	}

	public static void copyFile(File file) {
		File controller = new File(PATH + "/controller");
		File entity = new File(PATH + "/entity");
		File mapper = new File(PATH + "/mapper");
		File xml = new File(PATH + "/mapper/xml");
		File service = new File(PATH + "/service");
		File impl = new File(PATH + "/service/impl");

		controller.mkdirs();
		entity.mkdirs();
		mapper.mkdirs();
		service.mkdirs();
		xml.mkdirs();
		impl.mkdirs();
		File[] files = file.listFiles();
		for (File a : files) {
			if (a.isDirectory()) {
				copyFile(a);
			} else {
				System.out.println(a.getAbsolutePath());
				System.out.println(a.getName());
				String type = "";
				if (a.getName().endsWith("Mapper.java")) {
					type = "mapper";
				} else if (a.getName().endsWith("Mapper.xml")) {
					type = "mapper/xml";
				} else if (a.getName().endsWith("Service.java")) {
					type = "service";
				} else if (a.getName().endsWith("ServiceImpl.java")) {
					type = "service/impl";
				} else if (a.getName().endsWith("Controller.java")) {
					type = "controller";
				} else {
					type = "entity";
				}

				File tagFile = new File(PATH + "/" + type + "/" + a.getName());
				try {
					Files.copy(a.toPath(), tagFile.toPath());
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			}
		}
	}

	public static boolean deleteDir(File dir) {
		if (dir.isDirectory()) {
			String[] children = dir.list();
			for (int i = 0; i < children.length; i++) {
				boolean success = deleteDir(new File(dir, children[i]));
				if (!success) {
					return false;
				}
			}
		}
		return dir.delete();
	}

}
