package com.bnk.pay.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.bnk.pay.dao.HistoryDao;
import com.bnk.pay.dto.History;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class HistoryServiceImpl implements HistoryService{
	private final HistoryDao historyDao;
	public void save(History history) {
		historyDao.save(history);
	}
	public List<History> getLog(String code,String user_sn) {
		// TODO Auto-generated method stub
		if(code.equals("all")) { // all
			return historyDao.findAll();
		}else{ // deposit : 입금
			return historyDao.findByWorkdvAndUser_sn(code,user_sn);
		}
	}

}
