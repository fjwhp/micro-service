package com.whp.demo;

import java.util.Date;
import java.util.List;
import java.util.concurrent.Future;

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
import com.whp.config.properties.SystemBaseProperties;
import com.whp.core.pojo.CoreUser;
import com.whp.core.repository.CoreUserRepository;
import com.whp.user.pojo.TDept;
import com.whp.user.pojo.User;
import com.whp.user.repository.DeptRepository;
import com.whp.user.repository.UserRepository;

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
	private UserRepository userRepository;
	@Autowired
	private DeptRepository deptRepository;
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
	SystemBaseProperties pro;
	@Autowired
	AsysncTheadTaskService asysncTheadTaskService;

	@Test
	public void getProperty() {

		System.out.println(pro.getProjectName());
	}

	@Test
	public void getHello() throws Exception {
		String uri = "/hello";
		sendeHttpTest(uri);
	}

	@Test
	public void getUser() {
		log.debug("======================22");
		User user = new User();
		user.setEmail("qq.com");
		user.setUserName("whp");
		user.setPwd("123");
		userRepository.save(user);
	}

	@Test
	public void test() throws Exception {
		try {
			User u1 = userRepository.findByUserName("whp");
			System.out.println("第一次查询：" + u1.getEmail());

			userRepository.updateUser("11222.1m", "whp");

			User u2 = userRepository.findByUserName("whp");
			System.out.println("第二次查询：" + u2.getEmail());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * 测试异步线程
	 */
	@Test
	public void testAsync() {
		try {

			//for (int i = 0; i < 10; i++) {
				Future<String> f = asysncTheadTaskService.asyncInvokeReturnFuture(1);
			//}
				while (f.isDone()) {
					log.info("线程执行完毕");
					Thread.sleep(1000);
				}
			if (f.isDone()) {
				log.info("所有线程完成。。。。");
			} else {
				log.info("线程未完全。。。。");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	@Test
    public void jpaTest(){
        List<TDept> list=deptRepository.findAll();
        System.out.println(list.size());
        
        long i=deptRepository.count();
        TDept tDept =new TDept();
        tDept.setDeptName11("1111");
        deptRepository.save(tDept);
        System.out.println("长度=="+i);
    }
	
	@Test
	@Rollback(false)
	public void coreTest(){
		for (int i = 0; i <20; i++) {
			 CoreUser user =new CoreUser();
			    user.setUserName("wuhp"+i);
			    user.setIsActive(1);
			    user.setPlatform(1);
			    user.setUpdateTime(new Date());
			    user.setUpdateUserId(1l);
			    user.setUserName("whp");
			    user.setVersion(1);
			    user.setIsDelete("1");
			    user.setCreateUserId(1l);
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
		 condition.setIsActive(1);
		 Example<CoreUser> example=Example.of(condition);
		// Page<CoreUser> page=coreUserRepository.findAll(pageable);
		 Page<CoreUser> page= coreUserRepository.findAll(example, pageable);
		 System.out.println(page.getSize());
	}
	@Test
	public void updateUserTest(){
		CoreUser user =new CoreUser();
		user.setUserId(1l);
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
