package com.myschool.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.myschool.dao.UserDao;
import com.myschool.dto.User;

@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	@Override
	public boolean addNewUser(User user) {

		hibernateTemplate.save(user);
//		hibernateTemplate.loadAll(User.class);
		
		return true;
	}

}
