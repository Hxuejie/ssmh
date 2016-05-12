package com.hxj.test.ssmh.service;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.util.Assert;

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
		context = new AnnotationConfigApplicationContext("com.hxj.test.ssmh.dao", //Dao
														 "com.hxj.test.ssmh.service"); //Service
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCreateUser() {
		UserService userService = context.getBean(UserService.class);
		Assert.notNull(userService);
		User user = userService.createUser("hxj");
		Assert.notNull(user);
		Assert.state("hxj".equals(user.getName()));
	}

}
