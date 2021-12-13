package com.bnk.pay.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.apache.tomcat.jni.Time;
import org.hibernate.type.LocalDateTimeType;
import org.springframework.stereotype.Service;

import com.bnk.pay.dao.AccountDao;
import com.bnk.pay.dao.TestDao;
import com.bnk.pay.dto.Account;
import com.bnk.pay.dto.Test;
import lombok.RequiredArgsConstructor;
@RequiredArgsConstructor
@Service
public class AccountServiceImpl implements AccountService {
	private final TestDao testDao;
	private final AccountDao accountDao;
	@Override
	public Optional<Test> readTest(int id) {
		
		return testDao.findById(id);
	}

	@Override
	public Optional<Account> balance(String id) {
		return accountDao.findByUserid(id);
	}

	@Override
	public int remit(String msn, String osn, int amount) {
		Account mine = accountDao.findByUserid(msn).get();
		if(mine.getBalance()<amount) // 계좌 잔액 부족
			return -1;
		mine.setBalance(mine.getBalance()-amount);
		mine.setLastchangedtti(LocalDateTime.now());
		accountDao.save(mine);
		
		Account other = accountDao.findByUserid(osn).get();
		other.setBalance(other.getBalance()-amount);
		other.setLastchangedtti(LocalDateTime.now());
		accountDao.save(other);
		return 1;
	}

	public void createAccount(String id) { // 계좌생성
		Account acc = new Account();
		acc.setUserid(id);
		acc.setBalance(0);
		acc.setUseyn('Y');
		acc.setLastchangedtti(LocalDateTime.now());
		accountDao.save(acc);
		
	}
	
}
