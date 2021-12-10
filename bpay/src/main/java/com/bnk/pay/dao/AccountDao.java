package com.bnk.pay.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bnk.pay.dto.Account;

public interface AccountDao extends JpaRepository<Account, String> {

	public Optional<Account> findByUserid(String id);
}
