package com.bnk.pay.controller;

import java.util.HashMap;

import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bnk.pay.dto.Account;
import com.bnk.pay.dto.Test;
import com.bnk.pay.service.AccountServiceImpl;

import lombok.RequiredArgsConstructor;

import org.slf4j.Logger;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/account")
@RequiredArgsConstructor
public class AccountController {
	private final AccountServiceImpl accountServiceImpl;
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	@GetMapping(value = "/read")
	public ResponseEntity<HashMap<String,Object>> read() {
		HashMap<String,Object> ret = new HashMap<>();
		try {
			logger.info("test Controller");
			Test test = accountServiceImpl.readTest(1).get();
			ret.put("test", test);
			return new ResponseEntity<>(ret, HttpStatus.OK);
		} catch (Exception e) {
			ret.put("error",e);
			return new ResponseEntity<>(ret, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping(value = "/balance")
	public ResponseEntity<HashMap<String,Object>> balance(String id) {
		HashMap<String,Object> ret = new HashMap<>();
		try {
			logger.info("balance view");
			Account bal = accountServiceImpl.balance(id).get();
			ret.put("bal", bal);
			return new ResponseEntity<>(ret, HttpStatus.OK);
		} catch (Exception e) {
			ret.put("error",e);
			return new ResponseEntity<>(ret, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping(value = "/remit")
	public ResponseEntity<HashMap<String,Object>> remit(String mid,String oid,int money) {
		HashMap<String,Object> ret = new HashMap<>();
		try {
			logger.info("remit");
			int flag = accountServiceImpl.remit(mid,oid,money);
			if(flag==0) {
				ret.put("status", "잔액부족");
				return new ResponseEntity<>(ret, HttpStatus.OK);
			}
			else if(flag==1) {
				ret.put("status", "송금완료");
				return new ResponseEntity<>(ret, HttpStatus.OK);
			}
			else {
				ret.put("status", "오류발생");
				return new ResponseEntity<>(ret, HttpStatus.BAD_GATEWAY);
			}
		} catch (Exception e) {
			ret.put("error",e);
			return new ResponseEntity<>(ret, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	public void createAccount(String id) {
		try {
			logger.info("createAccount");
			accountServiceImpl.createAccount(id);
		} catch (Exception e) {
			
		}
	}
	
}
