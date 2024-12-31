package com.example.hairremoval.config;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Component;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

  private static final String FIXED_USERNAME = "test";
  private static final String FIXED_PASSWORD = "123";

@Override
public Authentication authenticate(Authentication authentication) throws AuthenticationException {

  String userName = authentication.getName();
  String password = (String) authentication.getCredentials();

  if(FIXED_USERNAME.equals(userName) && FIXED_PASSWORD.equals(password)){
    return new UsernamePasswordAuthenticationToken(userName,password,null);
  }else {
    throw new BadCredentialsException("Authentication failed");
  }
}

  @Override
  public boolean supports(Class<?> authentication) {
    // authentication(認証方式)がUsernamePasswordAuthenticationToken.class(ユーザー名とパスワード認証)か判定
    return authentication.equals(UsernamePasswordAuthenticationToken.class);
  }
}
