package com.myschool.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myschool.dao.UserDao;
import com.myschool.dto.User;
import com.myschool.services.UserService;

@Service
@Transactional(readOnly=false)
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userdao;
	
	@Override
	public boolean addNewUser(String username) {
		System.out.println(userdao);
		User user = new User();
		user.setUserName("Abraham");
		
		userdao.addNewUser(user);
		
		return true;
	}

}
