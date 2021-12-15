package com.bnk.pay.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.bnk.pay.dao.SubscribeDao;
import com.bnk.pay.dao.UserDao;
import com.bnk.pay.dto.User;
import com.bnk.pay.handler.ex.CustomApiException;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SubscribeServiceImpl implements SubscribeService {
	
	private final SubscribeDao subscribeDao;
	private final UserDao userDao;
	@Transactional
	public void 구독하기(String user_sn, String username) {
		User fromUser = userDao.findByUserSn(user_sn);
		User toUser = userDao.findByUsername(username);
		System.out.println("====================");
		System.out.println(toUser.getIdx());
		System.out.println(fromUser.getIdx());
		int fromUserId = fromUser.getIdx();
		int toUserId = toUser.getIdx();
		try {
			subscribeDao.mSubscribe(fromUserId, toUserId);
		} catch (Exception e) {
			throw new CustomApiException("이미 구독을 하였습니다.");
		}
		
	}
	
	@Transactional
	public void 구독취소하기(int fromUserId, int toUserId) {
		subscribeDao.mUnSubscribe(fromUserId, toUserId);
	}

	
}
