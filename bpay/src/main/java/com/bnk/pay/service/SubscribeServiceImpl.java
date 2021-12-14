package com.bnk.pay.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.bnk.pay.dao.SubscribeDao;
import com.bnk.pay.dao.UserDao;
import com.bnk.pay.dto.User;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SubscribeServiceImpl implements SubscribeService {
	
	private final SubscribeDao subscribeDao;
	private final UserDao userDao;
	@Transactional
	public void 구독하기(String username, int toUserId) {
		User user = userDao.findByUsername(username);
		System.out.println("====================");
		System.out.println(user);
		int fromUserId = user.getIdx();
		System.out.println(fromUserId);
		System.out.println(toUserId);
		try {
			subscribeDao.mSubscribe(fromUserId, toUserId);
		} catch (Exception e) {
			throw new RuntimeException("이미 구독을 하였습니다.");
		}
		
	}
	
	@Transactional
	public void 구독취소하기(int fromUserId, int toUserId) {
		subscribeDao.mUnSubscribe(fromUserId, toUserId);
	}

	
}
