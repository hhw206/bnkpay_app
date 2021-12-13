package com.bnk.pay.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.bnk.pay.dao.SubscribeDao;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SubscribeServiceImpl implements SubscribeService {
	
	private final SubscribeDao subscribeDao;
	
	@Transactional
	public void 구독하기(int fromUserId, int toUserId) {
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
