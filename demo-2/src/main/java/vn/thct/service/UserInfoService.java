package vn.thct.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import vn.thct.config.UserInfoUserDetail;
import vn.thct.entity.UserInfo;
import vn.thct.repository.UserInfoRepository;

public class UserInfoService implements UserDetailsService{

	@Autowired
	UserInfoRepository repository;

	public UserInfoService(UserInfoRepository repository) {
		this.repository = repository;
	}



	@Override
	public UserDetails loadUserByUsername (String username) throws
	UsernameNotFoundException {
	Optional<UserInfo> userInfo = repository.findByName(username);
	return userInfo.map(UserInfoUserDetail::new)
	.orElseThrow(() -> new UsernameNotFoundException("user not found:" + username));
	}	

}
