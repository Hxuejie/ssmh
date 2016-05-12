package com.hxj.test.ssmh.dao.impl;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.hxj.test.ssmh.dao.UserDao;
import com.hxj.test.ssmh.entity.User;

@Repository
public class UserDaoImpl implements UserDao {

	private SessionFactory	sessionFactory;

	@Override
	public void addUser(User user) {
		System.out.println("insert user to db:" + user);
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();
		session.close();
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	@Resource(name = "sessionFactory")
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
