package vn.thct.services;

import vn.thct.models.user_model;

public interface IUserService {
	user_model login(String username, String password);

	user_model findByUserName(String username);

	boolean register(user_model user);
	boolean forget_password(String username, String password);
	
}
