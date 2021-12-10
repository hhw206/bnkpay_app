package com.bnk.pay.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bnk.pay.dao.TestDao;
import com.bnk.pay.dto.Test;
import lombok.RequiredArgsConstructor;
@RequiredArgsConstructor
@Service
public class AccountServiceImpl implements AccountService {
	private final TestDao testDao;
	
	@Override
	public Optional<Test> readTest(int id) {
		
		return testDao.findById(id);
	}
	
}
