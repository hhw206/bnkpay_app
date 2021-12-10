package com.bnk.pay.controller;

import java.util.HashMap;

import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
