package com.bnk.pay.dto;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class History {
	@Id
	private int idx;
	private String otherUserName;
	private String otherUserId;
	private String userSn;
	private int amount;
	private String workdv;
	private LocalDateTime dtti;
}
