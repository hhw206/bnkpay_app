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
@Table(name = "tb_charge")
public class Charge {
	
	@Id
	private int idx;
	private String userSn;
	private int amount;
	private LocalDateTime dtti;
	private String type;
}
