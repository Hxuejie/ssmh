package com.hxj.test.ssmh.entity;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class UserTest {

	private SessionFactory	sessionFactory;

	@Before
	public void setUp() throws Exception {
		// A SessionFactory is set up once for an application!
		final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure() // configures settings
																									// from
																									// hibernate.cfg.xml
				.build();
		try {
			sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
		} catch (Exception e) {
			// The registry would be destroyed by the SessionFactory, but we had trouble building the SessionFactory
			// so destroy it manually.
			e.printStackTrace();
			StandardServiceRegistryBuilder.destroy(registry);
		}
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test1Save() {
		User user = new User();
		user.setName("abc");
		user.setAge(123);

		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();
		session.close();

		Assert.assertEquals(user.getId(), 1);

	}

	@Test
	public void test2Query() {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		List<?> result = session.createQuery("from com.hxj.test.ssmh.entity.User").list();
		session.getTransaction().commit();
		session.close();

		Assert.assertEquals(result.size(), 1);
		User user = (User) result.get(0);
		Assert.assertEquals(user.getName(), "abc");
		Assert.assertEquals(user.getAge(), 123);
		Assert.assertEquals(user.getId(), 1);

	}

}
