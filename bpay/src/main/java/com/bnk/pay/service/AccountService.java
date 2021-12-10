package com.bnk.pay.service;

import java.util.Optional;

import com.bnk.pay.dto.Test;

import lombok.RequiredArgsConstructor;
public interface AccountService {
	public Optional<Test> readTest(int id);
}
