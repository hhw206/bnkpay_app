package com.bnk.pay.controller;


import java.util.HashMap;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bnk.pay.config.PrincipalDetails;
import com.bnk.pay.dto.CMRespRequest;
import com.bnk.pay.dto.Login;
import com.bnk.pay.dto.User;
import com.bnk.pay.dto.UserRequest;
import com.bnk.pay.service.UserService;

import lombok.RequiredArgsConstructor;

@CrossOrigin(origins = "*")
@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
	private final UserService userService;
	
 	@PostMapping(value = "/signup")
    public ResponseEntity<HashMap<String,Object>> signup(@RequestBody UserRequest userRequest) {
 		HashMap<String,Object> ret = new HashMap<>();
 		System.out.println("test");
        try {
                User user = userService.signUp(userRequest);
                ret.put("user", user);
                return new ResponseEntity<>(ret, HttpStatus.OK);
            }
        catch (Exception e) {
        	System.out.println(e);
        	System.out.println("Error");
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
 	
    @PostMapping(value = "/signin")
    public ResponseEntity<HashMap<String,Object>> signin(@RequestBody Login login) {
    	HashMap<String,Object> ret = new HashMap<>();
    	
        try {
                User user = userService.signIn(login);
                if (user == null) {
                	ret.put("status","로그인 실패");
                	return new ResponseEntity<>(ret, HttpStatus.OK);
                }
                ret.put("status","로그인 성공");
                ret.put("user", user);
                return new ResponseEntity<>(ret, HttpStatus.OK);
            }
        catch (Exception e) {
        	System.out.println(e);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
 	
}
