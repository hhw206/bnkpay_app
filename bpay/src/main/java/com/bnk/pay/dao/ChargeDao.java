package com.bnk.pay.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bnk.pay.dto.Charge;

public interface ChargeDao extends JpaRepository<Charge, String>{
	Optional<Charge> findByUserSn(String user_sn); 
}
