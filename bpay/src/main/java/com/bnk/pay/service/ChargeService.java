package com.bnk.pay.service;

import com.bnk.pay.dto.Charge;
import com.bnk.pay.dto.ChargeRequest;
import com.bnk.pay.dto.WithdrawRequest;

public interface ChargeService {
	Charge charge(ChargeRequest chargeRequest);
	Charge withdraw(WithdrawRequest withdrawRequest);
}
