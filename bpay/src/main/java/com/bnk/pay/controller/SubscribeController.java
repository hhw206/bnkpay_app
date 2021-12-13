package com.bnk.pay.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bnk.pay.config.PrincipalDetails;
import com.bnk.pay.dto.CMRespDto;
import com.bnk.pay.service.SubscribeServiceImpl;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class SubscribeController {
	
	private final SubscribeServiceImpl subscribeServiceImpl;
	
	@PostMapping("api/subscribe/{toUserId}")
	public ResponseEntity<?> subscribe(@AuthenticationPrincipal  PrincipalDetails principalDetails,
			@PathVariable int toUserId) {
		subscribeServiceImpl.구독하기(principalDetails.getUser().getIdx(), toUserId);
		return new ResponseEntity<>(new CMRespDto<>(1,"구독하기 성공",null),HttpStatus.OK);
	}
	
	@DeleteMapping("api/subscribe/{toUserId}")
	public ResponseEntity<?> unSubscribe(@AuthenticationPrincipal  PrincipalDetails principalDetails,
			@PathVariable int toUserId) {
		subscribeServiceImpl.구독취소하기(principalDetails.getUser().getIdx(), toUserId);
		return new ResponseEntity<>(new CMRespDto<>(1,"구독취소하기 성공",null),HttpStatus.OK);
	}


}
