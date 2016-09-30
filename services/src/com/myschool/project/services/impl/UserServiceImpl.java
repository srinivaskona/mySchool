package com.myschool.project.services.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myschool.project.dao.UserDao;
import com.myschool.project.dto.User;
import com.myschool.project.services.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userdao;
	
	@Override
	public boolean addNewUser(String username) {

		User user = new User();
//		user.setUserId("1235");
		user.setUserName("Tej");
		user.setUserCreation(new Date());
		
		userdao.addNewUser(user);
		
		return true;
	}

}
