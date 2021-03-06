package com.bnk.pay.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "tb_user")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idx;
	@Column(unique = true)
    private String username; // 유저 id
    private String password;
    private String name;     // 실제 이름
    private char user_dv;  
    private char use_yn;
    private String userSn;
    private String token;
    
}