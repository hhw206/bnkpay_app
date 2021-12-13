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
import com.bnk.pay.dto.UserRequest;
import com.bnk.pay.service.ChargeService;
import com.bnk.pay.service.ChargeServiceImpl;

import lombok.RequiredArgsConstructor;
@CrossOrigin(origins = "*")
@RestController
@RequiredArgsConstructor
@RequestMapping("/Charge")
public class ChargeController {
//	private final ChargeServiceImpl chargeServiceImpl;
// 	@PostMapping(value = "/charge")
//    public ResponseEntity<HashMap<String,Object>> charge(@RequestBody UserRequest user) {
// 		HashMap<String,Object> ret = new HashMap<>();
//        try {
//                ret.put("user", user);
//                return new ResponseEntity<>(ret, HttpStatus.OK);
//            }
//        catch (Exception e) {
//            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
}