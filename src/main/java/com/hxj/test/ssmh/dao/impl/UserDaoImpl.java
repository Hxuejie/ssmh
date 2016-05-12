package com.hxj.test.ssmh.dao.impl;

import org.springframework.stereotype.Repository;

import com.hxj.test.ssmh.dao.UserDao;
import com.hxj.test.ssmh.entity.User;

@Repository
public class UserDaoImpl implements UserDao {
	@Override
	public void addUser(User user) {
		System.out.println("insert user to db:" + user);
	}
}
