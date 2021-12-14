package com.bnk.pay.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChargeRequest {
	    private String user_sn;
	    private int amount;
	    //private LocalDateTime dtti;
	    //private String type;
}
