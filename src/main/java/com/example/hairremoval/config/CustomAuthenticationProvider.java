package com.example.hairremoval.config;

import com.example.hairremoval.utils.MessageUtils;
import lombok.extern.slf4j.Slf4j;
import org.seasar.doma.jdbc.JdbcException;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

/**
 * ユーザー名とパスワードによる認証を処理するプロバイダークラス
 */
@Component
@Slf4j
public class CustomAuthenticationProvider implements AuthenticationProvider {

  private final UserDetailsService userDetailsService;
  private final PasswordEncoder passwordEncoder;

  public CustomAuthenticationProvider(UserDetailsService userDetailsService, PasswordEncoder passwordEncoder) {
    this.userDetailsService = userDetailsService;
    this.passwordEncoder = passwordEncoder;
  }

  /**
   * 認証処理
   * @param authentication 認証情報
   * @return 認証済みのAuthenticationオブジェクト
   * @throws AuthenticationException 認証にした場合
   */
  @Override
  public Authentication authenticate(Authentication authentication) throws AuthenticationException {
    try {

      String username = authentication.getName();
      String inputPassword = (String) authentication.getCredentials();
      log.info("userName");
      log.info(username);
      log.info("inputPassword");
      log.info(inputPassword);
      UserDetails userDetails = userDetailsService.loadUserByUsername(username);

      if(passwordEncoder.matches(inputPassword, userDetails.getPassword())){
        return new UsernamePasswordAuthenticationToken(username,inputPassword,userDetails.getAuthorities());
      }else {
        throw new BadCredentialsException(MessageUtils.getMessage("errorPasswordMessage"));
      }
    } catch (JdbcException e){
      throw new AuthenticationServiceException(MessageUtils.getMessage("jdbcExceptionMessage"));
    }
  }

  @Override
  public boolean supports(Class<?> authentication) {
    // authentication(認証方式)がUsernamePasswordAuthenticationToken.class(ユーザー名とパスワード認証)か判定
    return authentication.equals(UsernamePasswordAuthenticationToken.class);
  }
}
