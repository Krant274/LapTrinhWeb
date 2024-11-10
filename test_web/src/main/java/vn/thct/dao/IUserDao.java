package vn.thct.dao;

import java.util.List;

import vn.thct.models.user_model;

public interface IUserDao {
	List<user_model> findAll();

	user_model findById(int id);

	void insert(user_model user);

	user_model findByUserName(String username);

	boolean checkExistEmail(String email);

	boolean checkExistUsername(String username);
	
	boolean changePassword(String username, String password);

}
