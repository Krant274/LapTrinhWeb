package vn.thct.services.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import vn.thct.connections.DBConnection;
import vn.thct.dao.IUserDao;
import vn.thct.dao.impl.UserDaoImpl;
import vn.thct.models.user_model;
import vn.thct.services.IUserService;

public class UserServiceImpl  implements IUserService{
	IUserDao userDao = new UserDaoImpl();
	
	
	@Override
	public user_model login(String username, String password) {
		user_model user = this.findByUserName(username);
		if(user != null && password.equals(user.getPassword())) {
			return user;
		}
		return null;
	}

	@Override
	public user_model findByUserName(String username) {
		return userDao.findByUserName(username);
	}

	@Override
	public boolean register(user_model user) {
		if(userDao.checkExistUsername(user.getUsername())) {
			return false;
		}
		
		if(userDao.checkExistEmail(user.getEmail())){
			return false;
		}
		long millis=System.currentTimeMillis();
		java.sql.Date date=new java.sql.Date(millis);
		userDao.insert(user);
		
		return true;
	}

	@Override
	public boolean forget_password(String username, String password) {
		if(userDao.checkExistUsername(username)) {
			if(userDao.changePassword(username, password)) {
				return true;
			}
		}
		return false;
	}

	

	
}
