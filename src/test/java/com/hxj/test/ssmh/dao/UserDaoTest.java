package com.hxj.test.ssmh.dao;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.util.Assert;

import com.hxj.test.ssmh.dao.UserDao;

/**
 * spring bean 测试<BR>
 * 
 * @author Hxuejie hxuejie@126.com
 */
public class UserDaoTest {
	private ApplicationContext	context;

	@Before
	public void setUp() throws Exception {
		context = new AnnotationConfigApplicationContext("com.hxj.test.ssmh.dao");
	}

	@After
	public void tearDown() throws Exception {
	}

	/**
	 * 测试string注解扫描
	 */
	@Test
	public void testAnnotationScan() {
		UserDao userDao = context.getBean(UserDao.class);
		Assert.notNull(userDao);
	}

}
