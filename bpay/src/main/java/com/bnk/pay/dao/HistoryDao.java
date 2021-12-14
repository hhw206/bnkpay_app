package com.bnk.pay.dao;

import java.util.List;

import javax.persistence.OrderBy;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bnk.pay.dto.History;

public interface HistoryDao extends JpaRepository<History, Integer> {
	
	List<History> findByWorkdvAndUser_sn(String code,String user_sn);
	
}
