package com.bnk.pay.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Login {
    private String username;  // 사용자 id
    private String password;
}