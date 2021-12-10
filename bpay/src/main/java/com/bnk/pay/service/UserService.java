package com.bnk.pay.service;

import com.bnk.pay.dto.Login;
import com.bnk.pay.dto.User;
import com.bnk.pay.dto.UserRequest;

public interface UserService {

	User signUp(UserRequest userRequest);

	User signIn(Login login);

}
