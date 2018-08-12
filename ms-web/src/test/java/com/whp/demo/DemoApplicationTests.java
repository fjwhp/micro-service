package com.whp.demo;

import java.util.Date;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.whp.async.AsysncTheadTaskService;
import com.whp.core.pojo.CoreUser;
import com.whp.core.repository.CoreUserRepository;

/**
 * 
 * @描述：测试类
 *
 * @作者：wuhp
 * 
 * @时间：2018年3月8日 下午3:19:17
 */
// 告诉Junit运行使用Spring 的单元测试支持
@RunWith(SpringRunner.class)
// 带有Spring Boot支持的引导程序
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class DemoApplicationTests {

	private Logger log = LoggerFactory.getLogger(DemoApplicationTests.class);
	@Resource
	private WebApplicationContext context;
	private MockMvc mvc;
	private String httpHeader = "http://localhost:8080";
	@Autowired
	private CoreUserRepository coreUserRepository;
	
	@Before
	public void setupMvc() throws Exception {
		mvc = MockMvcBuilders.webAppContextSetup(context).build();
	}

	// 以下是junit测试内容
	// ##############################################################################
	/**
	 * 如果用到status、content、equalTo，需要引入以下 import static
	 * org.hamcrest.Matchers.equalTo; import static
	 * org.springframework.test.web.servlet.result.MockMvcResultMatchers.
	 * content; import static
	 * org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
	 * 
	 * 
	 */
	@Autowired
	AsysncTheadTaskService asysncTheadTaskService;


	@Test
	public void getHello() throws Exception {
		String uri = "/hello";
		sendeHttpTest(uri);
	}
	@Test
	public void asynTest(){
		asysncTheadTaskService.asyncInvokeSimplest();
	}
	
	@Test
	@Rollback(false)
	public void coreTest(){
		for (int i = 0; i <20; i++) {
			 CoreUser user =new CoreUser();
			    user.setUserName("wuhp"+i);
			    user.setPlatform(1);
			    user.setUpdateTime(new Date());
//			    user.setUpdateUserId(1l);
			    user.setUserName("whp");
			    user.setVersion(1);
			    user.setIsDelete("1");
//			    user.setCreateUserId(1l);
			    user.setCreateUserName("xx");
			    user.setUpdateUserName("yyy");
			    user.setUserPwd("123qwe");
			    //user.setUserId(Long.parseLong(i));
			    user.setCreateTime(new Date());
			    coreUserRepository.save(user);
		}
	   
	    //coreUserRepository.findAll();
	}
	@Test
	public void pageUserTest(){
		 Sort sort = new Sort(Sort.Direction.DESC,"createTime"); //创建时间降序排序
		 Pageable pageable = new PageRequest(1,8,sort);
		 CoreUser condition= new CoreUser();
		 Example<CoreUser> example=Example.of(condition);
		// Page<CoreUser> page=coreUserRepository.findAll(pageable);
		 Page<CoreUser> page= coreUserRepository.findAll(example, pageable);
		 System.out.println(page.getSize());
	}
	@Test
	public void updateUserTest(){
		CoreUser user =new CoreUser();
//		user.setUserId(1l);
		user.setUserName("xxxxxxxxxxxxxxxxxxxxxx");
		coreUserRepository.save(user);
	}

	// 以下是封装内容
	// ##############################################################################
	/**
	 * 
	 * @描述：封装测试内容
	 *
	 * @返回：void
	 *
	 * @作者：wuhp
	 *
	 * @时间：2018年3月8日 下午3:57:31
	 */
	public void sendeHttpTest(String url) {
		try {
			log.info("开始执行--" + url);

			MockHttpServletRequestBuilder mhsrb = MockMvcRequestBuilders.post(httpHeader + url);

			MvcResult mvcResult = mvc.perform(mhsrb.accept(MediaType.APPLICATION_JSON)).andReturn();
			int status = mvcResult.getResponse().getStatus();
			String content = mvcResult.getResponse().getContentAsString();

			log.info("执行状态status====" + status);
			log.info("执行返回内容===" + content);
		} catch (Exception e) {
		} finally {
			log.info("结束执行--" + url);
		}

	}
	
}
