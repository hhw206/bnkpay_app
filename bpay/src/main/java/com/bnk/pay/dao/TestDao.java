package com.bnk.pay.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bnk.pay.dto.Test;

public interface TestDao extends JpaRepository<Test, Integer> {
	
}
