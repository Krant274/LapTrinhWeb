package vn.thct.service;

import org.springframework.security.crypto.password.PasswordEncoder;

import vn.thct.entity.UserInfo;
import vn.thct.repository.UserInfoRepository;

public record UserService(UserInfoRepository repository, PasswordEncoder passwordEncoder) {
	public String addUser(UserInfo userInfo) {
		userInfo.setPassword(passwordEncoder.encode(userInfo.getPassword()));
		repository.save(userInfo);
		return "added successfully new user";
	}

}
