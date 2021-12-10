package com.bnk.pay.service;

import java.util.List;
import java.util.Optional;

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
	public int remit(String mid, String oid, int money) {
		Account mine = accountDao.findByUserid(mid).get();
		if(mine.getBalance()<money) // 계좌 잔액 부족
			return -1;
		mine.setBalance(mine.getBalance()-money);
		accountDao.save(mine);
		
		Account other = accountDao.findByUserid(oid).get();
		other.setBalance(other.getBalance()-money);
		accountDao.save(other);
		return 1;
	}

	public void createAccount(String id) {
		Account acc = new Account();
		acc.setUserid(id);
		
		accountDao.save(acc);
		
	}
	
}
