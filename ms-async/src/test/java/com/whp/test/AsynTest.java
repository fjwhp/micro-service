package com.whp.test;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.whp.async.AsysncTheadTaskService;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
public class AsynTest {

	private Logger log = LoggerFactory.getLogger(AsynTest.class);
	@Resource
	private WebApplicationContext context;
	private MockMvc mvc;
	@Autowired
	AsysncTheadTaskService asysncTheadTaskService;
	
	@Before
	public void setupMvc() throws Exception {
		mvc = MockMvcBuilders.webAppContextSetup(context).build();
	}
	
	@Test
	public void testAsyn(){
		asysncTheadTaskService.asyncInvokeSimplest();
	}
}
