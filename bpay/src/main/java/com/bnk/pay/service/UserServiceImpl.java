package com.bnk.pay.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.bnk.pay.controller.AccountController;
import com.bnk.pay.dao.UserDao;
import com.bnk.pay.dto.Login;
import com.bnk.pay.dto.User;
import com.bnk.pay.dto.UserRequest;

import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{
	private final UserDao userDao;
	private final AccountController accountController;
	private final BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Override
	@Transactional
	public User signUp(UserRequest userRequest) {
		
		String rawPassword = userRequest.getPassword();
		String encPassword = bCryptPasswordEncoder.encode(rawPassword);
		
		
		User user = new User();
		user.setName(userRequest.getName());
		user.setPassword(encPassword);
		user.setToken(userRequest.getToken());
		user.setUsername(userRequest.getUsername());
		user.setUse_yn('Y');
		user.setUserSn(userRequest.getUser_sn());
		user.setUser_dv('1');
		
		accountController.createAccount(userRequest.getUser_sn());
		
		
		// TO DO
		// 추가 정보 기입.
		return userDao.save(user);
	}

	@Override
	public User signIn(Login login) {
		
		String rawPassword = login.getPassword();
		//String encPassword = bCryptPasswordEncoder.encode(rawPassword);
		
		User user = userDao.findByUsername(login.getUsername());
		if(user!=null)
		{	
			 if (bCryptPasswordEncoder.matches(login.getPassword(),user.getPassword() )) {
				 //System.out.println("==============================");
				 //System.out.println(user);
				 return user;
			 }
			 else {
				 return null;
			 }
		}
		return null;
	}

}
