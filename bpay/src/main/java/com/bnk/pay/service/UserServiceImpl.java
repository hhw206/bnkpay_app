package com.bnk.pay.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.bnk.pay.dao.UserDao;
import com.bnk.pay.dto.Login;
import com.bnk.pay.dto.User;
import com.bnk.pay.dto.UserRequest;

import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{
	private final UserDao userDao;
	
	@Override
	public User signUp(UserRequest userRequest) {
		User user = new User();
		user.setName(userRequest.getName());
		user.setPassword(userRequest.getPassword());
		user.setToken(userRequest.getToken());
		user.setUsername(userRequest.getUsername());
		// TO DO
		// 추가 정보 기입.
		return userDao.save(user);
	}

	@Override
	public User signIn(Login login) {
		Optional<User> user = userDao.findByUsernameAndPassword(login.getUsername(),login.getPassword());
		if(user!=null)
		{
			return user.get();
		}
		return null;
	}

}
