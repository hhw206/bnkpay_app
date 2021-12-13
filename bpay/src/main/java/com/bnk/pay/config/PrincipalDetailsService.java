package com.bnk.pay.config;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.bnk.pay.dao.UserDao;
import com.bnk.pay.dto.User;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PrincipalDetailsService implements UserDetailsService {
   
   private final UserDao userRepository;

   @Override
   public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
      User userEntity = userRepository.findByUsername(username);
      if(userEntity == null) {
         return null;
      } else {
         return new PrincipalDetails(userEntity);
      }
   }
}
   