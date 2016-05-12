package com.hxj.test.ssmh.bean;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.util.Assert;

/**
 * spring bean 测试<BR>
 * 
 * @author Hxuejie hxuejie@126.com
 */
public class UserTest {
	private ApplicationContext	context;

	@Before
	public void setUp() throws Exception {
		context = new AnnotationConfigApplicationContext("com.hxj.test.ssmh.bean");
	}

	@After
	public void tearDown() throws Exception {
	}

	/**
	 * 测试string注解扫描
	 */
	@Test
	public void testAnnotationScan() {
		User user = context.getBean(User.class);
		Assert.notNull(user);
	}

}
