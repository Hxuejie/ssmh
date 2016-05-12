package com.hxj.test.ssmh.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hxj.test.ssmh.dao.UserDao;
import com.hxj.test.ssmh.entity.User;

@Service
public class UserService {

	private UserDao	userDao;

	public User createUser(String name) {
		User user = new User();
		user.setName(name);
		userDao.addUser(user);
		return user;
	}

	public UserDao getUserDao() {
		return userDao;
	}

	@Autowired
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

}
