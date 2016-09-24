package dao.impl;

import org.springframework.stereotype.Repository;

import dao.AbstractDao;
import dao.UserDao;
import dto.User;

@Repository
public class UserDaoImpl extends AbstractDao implements UserDao {

	@Override
	public boolean addNewUser(User user) {

		getSession().save(user);
		
		return false;
	}

}
