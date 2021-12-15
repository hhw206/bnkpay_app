package com.bnk.pay.dto;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class Account {
	
	@Id
	@Column(name = "user_sn")
	String userSn;
	int balance;
	LocalDateTime lastchangedtti;
	LocalDateTime joindtti;
	char useyn;
} 
