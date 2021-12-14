package com.bnk.pay.controller;

import java.time.LocalDateTime;
import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bnk.pay.dto.History;
import com.bnk.pay.service.HistoryServiceImpl;

import lombok.RequiredArgsConstructor;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/history")
@RequiredArgsConstructor
public class HistoryController {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	private final HistoryServiceImpl historyServiceImpl;
	
	@GetMapping(value = "/")
	public ResponseEntity<HashMap<String,Object>> read(String code,String user_sn) {
		HashMap<String,Object> ret = new HashMap<>();
		try {
			logger.info("History Controller");
			ret.put("return",historyServiceImpl.getLog(code,user_sn));
			return new ResponseEntity<>(ret, HttpStatus.OK);
		} catch (Exception e) {
			ret.put("error",e);
			return new ResponseEntity<>(ret, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	public void charge_log(String user_sn,int amount,String workdv) {
		try {
			logger.info("history in");
			History his = new History();
			his.setUser_sn(user_sn);
			his.setAmount(amount);
			his.setDtti(LocalDateTime.now());
			his.setWorkdv(workdv);
			historyServiceImpl.save(his);
		} catch (Exception e) {
			logger.info(e.toString());
		}
	}
	public void account_log(String user_sn,int amount,String workdv,String other_user_name,String other_user_id) {
		try {
			logger.info("history in");
			History his = new History();
			his.setUser_sn(user_sn);
			his.setAmount(amount);
			his.setDtti(LocalDateTime.now());
			his.setWorkdv(workdv);
			his.setOther_user_id(other_user_id);
			his.setOther_user_name(other_user_name);
			historyServiceImpl.save(his);
		} catch (Exception e) {
			logger.info(e.toString());
		}
	}
	
}
