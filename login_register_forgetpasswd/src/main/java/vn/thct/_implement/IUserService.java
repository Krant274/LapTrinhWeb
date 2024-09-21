package vn.thct._implement;

import vn.thct._interface.UserDao;
import vn.thct._interface.UserService;
import vn.thct.models.User;

public class IUserService implements UserService {
	UserDao userDao = new IUserDao();

	@Override
	public User login(String username, String password) {
		User user = this.findByUsername(username);
		if (user != null && password.equals(user.getPassWord())) {
			return user;
		}
		return null;
	}

	@Override
	public User findByUsername(String username) {
		return userDao.findByUsername(username);
	}

	@Override
	public boolean register(String username, String password, String email, String fullname, String avatar, String phone) {
		if (userDao.checkExistUsername(username)) {
			return false;
		}
		long millis = System.currentTimeMillis();
		java.sql.Date date = new java.sql.Date(millis);
		userDao.insert(new User(email, username, fullname, password, avatar, phone, 5, date));
		return true;
	}

	public boolean checkExistEmail(String email) {
		return userDao.checkExistEmail(email);
	}

	public boolean checkExistUsername(String username) {
		return userDao.checkExistUsername(username);
	}

	@Override
	public boolean checkExistPhone(String phone) {
		return userDao.checkExistPhone(phone);
	}

	@Override
	public void insert(User user) {
		userDao.insert(user);
	}

	@Override
	public boolean reset_passwd(String new_passwd, String username) {
		if (!userDao.checkExistUsername(username)) {
			return false;
		}
		userDao.reset_passwd(new_passwd, username);
		return true;
		
	}
}
