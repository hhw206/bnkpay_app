package com.bnk.pay.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bnk.pay.dto.Account;
import com.bnk.pay.dto.User;

public interface UserDao extends JpaRepository<User, String> {

	Optional<User> findByUsernameAndPassword(String username, String password);

	User findByUsername(String username);
}
