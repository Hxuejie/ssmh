package com.hxj.test.ssmh.dao.impl;

import java.util.List;

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
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public User findUser(int id) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		List<?> result = session.createQuery("from com.hxj.test.ssmh.entity.User").list();
		session.getTransaction().commit();
		session.close();
		if (result.isEmpty()) {
			return null;
		}
		return (User) result.get(0);
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	@Resource(name = "sessionFactory")
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
