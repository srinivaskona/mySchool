package com.myschool.dao;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public abstract class AbstractDao {

	@Resource(name="sessionFactory")
	private SessionFactory sessionFactory;

	protected Session getSession(){
		Session s = sessionFactory.getCurrentSession();
		return s;
	}

	public void persist(Object enitity){
		getSession().persist(enitity);
	}

	public void delete(Object entity){
		getSession().delete(entity);
	}

}
