package vn.thct._interface;

import java.util.List;

import vn.thct.models.User;

public interface UserDao {
	List<User> findall();
	User findById(int id);
	void insert(User user);
	User findByUsername(String username);
	
	boolean checkExistEmail(String email);
	boolean checkExistUsername(String username);
	boolean checkExistPhone(String phone);
	
	void reset_passwd(String new_passwd, String username);
	
}
