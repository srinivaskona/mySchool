package com.myschool.project.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.myschool.project.dao.UserDao;
import com.myschool.project.dto.User;

@Transactional
@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
    private SessionFactory sessionFactory;
	
	public UserDaoImpl() {
	}
	
	public UserDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	@Transactional
	public boolean addNewUser(User user) {
		sessionFactory.getCurrentSession().save(user);
		return true;
	}



}
