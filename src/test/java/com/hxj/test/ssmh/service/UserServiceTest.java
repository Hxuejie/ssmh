package com.hxj.test.ssmh.service;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hxj.test.ssmh.entity.User;

/**
 * 测试 string Autowired功能
 * 
 * @author Hxuejie hxuejie@126.com
 */
public class UserServiceTest {
	private ApplicationContext	context;

	@Before
	public void setUp() throws Exception {
		context = new ClassPathXmlApplicationContext("applicationContext.xml");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCreateUser() {
		UserService userService = context.getBean(UserService.class);
		Assert.assertNotNull(userService);
		User user = userService.createUser("hxj");
		Assert.assertNotNull(user);
		Assert.assertEquals(user.getName(), "hxj");
	}

	@Test
	public void testFindUser() {
		//create test data
		testCreateUser();
		
		UserService userService = context.getBean(UserService.class);
		Assert.assertNotNull(userService);
		User user = userService.findUser(1);
		Assert.assertNotNull(user);
		Assert.assertEquals(user.getName(), "hxj");
		
	}

}
