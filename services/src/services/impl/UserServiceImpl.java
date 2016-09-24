package services.impl;

import org.springframework.beans.factory.annotation.Autowired;

import dao.UserDao;
import dto.User;
import services.UserService;

public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userdao;
	
	@Override
	public boolean addNewUser(String username) {
		
		User user = new User();
		user.setUserName("Abraham");
		
		userdao.addNewUser(user);
		
		return true;
	}

}
