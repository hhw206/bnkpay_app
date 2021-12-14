package com.bnk.pay.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CMRespRequest <T>{
	private int code;
	private String message;
	private T data;

}
