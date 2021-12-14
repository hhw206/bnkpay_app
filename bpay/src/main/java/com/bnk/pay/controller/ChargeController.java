package com.bnk.pay.controller;

import java.util.HashMap;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bnk.pay.dto.Charge;
import com.bnk.pay.dto.ChargeRequest;
import com.bnk.pay.dto.WithdrawRequest;
import com.bnk.pay.service.ChargeService;
import com.bnk.pay.service.ChargeServiceImpl;

import lombok.RequiredArgsConstructor;

@CrossOrigin(origins = "*")
@RequiredArgsConstructor
@RequestMapping("/charge")
@RestController
public class ChargeController {
	private final ChargeService chargeService;
	@PostMapping(value = "/charging")
	public ResponseEntity<HashMap<String, Object>> charge(@RequestBody ChargeRequest chargeRequest) {
		HashMap<String, Object> ret = new HashMap<>();	
		try {
			System.out.println("charge test");
			System.out.println("charge request = " + chargeRequest);
			Charge charge = chargeService.charge(chargeRequest);
			ret.put("charge", charge);
			return new ResponseEntity<>(ret, HttpStatus.OK);
		} catch (Exception e) {
			System.out.println(e);
        	System.out.println("Error");
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@PostMapping(value = "/withdraw")
	public ResponseEntity<HashMap<String, Object>> withdraw(@RequestBody WithdrawRequest withdrawRequest) {
		HashMap<String, Object> ret = new HashMap<>();	
		try {
			Charge charge = chargeService.withdraw(withdrawRequest);
			ret.put("charge", charge);
			return new ResponseEntity<>(ret, HttpStatus.OK);
		} catch (Exception e) {
			System.out.println(e);
        	System.out.println("Error");
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}