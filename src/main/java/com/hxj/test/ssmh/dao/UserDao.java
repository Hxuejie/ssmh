package com.hxj.test.ssmh.dao;

import com.hxj.test.ssmh.entity.User;

public interface UserDao {

	void addUser(User user);

	User findUser(int id);

}