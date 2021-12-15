package com.bnk.pay.dto;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(
		uniqueConstraints = {
				@UniqueConstraint(
						name = "subscribe_uk",
						columnNames = {"fromUserId","toUserId"}
				)
		}
)
public class Subscribe {
	@Id // primary key 지정
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int sub_id;
	
	@JoinColumn(name = "fromUserId")
	@ManyToOne
	private User fromUserId; // 구독하는 애
	
	@JoinColumn(name = "toUserId")
	@ManyToOne
	private User toUserId; // 구독받는 애

	private LocalDateTime createDate;

	@PrePersist
	public void createDate() {
		this.createDate = LocalDateTime.now();
	}

}
