package com.bnk.pay.service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.bnk.pay.dao.ChargeDao;
import com.bnk.pay.dto.Charge;
import com.bnk.pay.dto.ChargeRequest;
import com.bnk.pay.dto.WithdrawRequest;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ChargeServiceImpl implements ChargeService {
	private final ChargeDao chargeDao;
	
	@Override
	public Charge charge(ChargeRequest chargeRequest) {
		Charge charge = new Charge();
		charge.setUserSn(chargeRequest.getUser_sn());
		charge.setAmount(chargeRequest.getAmount());
		charge.setDtti(LocalDateTime.now());
		charge.setType("01");
		
		Charge ret  = chargeDao.save(charge);
		
		//charge_log(chargeRequest.getUser_sn(), chargeRequest.getAmount(), "charge");
		// TODO Auto-generated method stub
		return ret;
	}
	@Override
	public Charge withdraw(WithdrawRequest withdrawRequest) {
		Charge withdraw = new Charge();
		withdraw.setUserSn(withdrawRequest.getUser_sn());
		withdraw.setAmount(withdrawRequest.getAmount());
		withdraw.setDtti(LocalDateTime.now());
		withdraw.setType("02");
		
		Charge ret  = chargeDao.save(withdraw);
		
		//charge_log(withdrawRequest.getUser_sn(), withdrawRequest.getAmount(), "withdraw");
		return ret;
	}
}
