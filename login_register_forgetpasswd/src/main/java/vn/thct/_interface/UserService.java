package vn.thct._interface;

import vn.thct.models.User;

public interface UserService {
	User login(String username, String password);

	User findByUsername(String username);

	void insert(User user);

	boolean register(String email, String password, String username, String fullname, String avatar, String phone);

	boolean checkExistEmail(String email);

	boolean checkExistUsername(String username);

	boolean checkExistPhone(String phone);
	
	boolean reset_passwd(String new_passwd, String username);

}
