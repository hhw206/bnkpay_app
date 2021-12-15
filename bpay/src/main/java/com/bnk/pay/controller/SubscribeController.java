package com.bnk.pay.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bnk.pay.config.PrincipalDetails;
import com.bnk.pay.dto.CMRespRequest;
import com.bnk.pay.dto.SubscribeRequest;

import com.bnk.pay.service.SubscribeServiceImpl;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class SubscribeController {
	
	private final SubscribeServiceImpl subscribeServiceImpl;

	@PostMapping("/subscribe")
	public ResponseEntity<?> subscribe(@RequestBody SubscribeRequest subscribeRequest) {
		System.out.println("========================");
		System.out.println(subscribeRequest);
		subscribeServiceImpl.구독하기(subscribeRequest.getUser_sn(),subscribeRequest.getUsername());
		return new ResponseEntity<>(new CMRespRequest<>(1,"구독하기 성공",null),HttpStatus.OK);


	}
	
	@DeleteMapping("/subscribe/{toUserId}")
	public ResponseEntity<?> unSubscribe(@AuthenticationPrincipal  PrincipalDetails principalDetails,
			@PathVariable int toUserId) {
		subscribeServiceImpl.구독취소하기(principalDetails.getUser().getIdx(), toUserId);

		return new ResponseEntity<>(new CMRespRequest<>(1,"구독취소하기 성공",null),HttpStatus.OK);

	}


}
