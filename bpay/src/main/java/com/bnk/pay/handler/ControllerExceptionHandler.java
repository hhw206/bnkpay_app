package com.bnk.pay.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import com.bnk.pay.dto.CMRespRequest;
import com.bnk.pay.handler.ex.CustomApiException;

@RestController
@ControllerAdvice
public class ControllerExceptionHandler {
	
	@ExceptionHandler(CustomApiException.class)
	public CMRespRequest<?> apiException(CustomApiException e) {
		return new CMRespRequest<>(-1,e.getMessage(),null);
	}
	
}
