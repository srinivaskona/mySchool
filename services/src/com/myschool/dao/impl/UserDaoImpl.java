package com.myschool.dao.impl;

import org.springframework.stereotype.Repository;

import com.myschool.dao.UserDao;
import com.myschool.dto.User;

@Repository
public class UserDaoImpl implements UserDao {

	@Override
	public boolean addNewUser(User user) {

//		getSession().save(user);
		
		return false;
	}

}
