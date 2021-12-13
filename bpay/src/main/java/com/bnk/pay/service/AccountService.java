package com.bnk.pay.service;

import java.util.List;
import java.util.Optional;

import com.bnk.pay.dto.Account;
import com.bnk.pay.dto.Test;

import lombok.RequiredArgsConstructor;
public interface AccountService {
	public Optional<Test> readTest(int id);
	public Optional<Account> balance(String id);
	public int remit(String msn,String osn,int amount);
	public void createAccount(String id);
}
