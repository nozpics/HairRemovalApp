package com.example.hairremoval.service;

import com.example.hairremoval.entity.User;
import static org.springframework.security.core.userdetails.User.builder;

import com.example.hairremoval.utils.MessageUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * UserDetailsServiceインターフェースを実装し、
 * ユーザー認証に必要な情報を提供するサービスクラス
 */
@Service
public class CustomUserDetailsService implements UserDetailsService {

  private final UserService userService;

  public CustomUserDetailsService(UserService userService) {
    this.userService = userService;
  }


  /**
   *指定されたユーザー名（ユーザーID）で認証で使用する情報を読み込む
   * @param username ユーザー名（ユーザーID）
   * @return 認証に使用される情報
   * @throws UsernameNotFoundException 無効なユーザーIDの場合にスローされる
   */
  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    //入力されたユーザーIDが文字列だった場合。
    if(!username.matches("\\d+")){
      throw new UsernameNotFoundException(MessageUtils.getMessage("userIdErrorMessage"));
    }else {
      int userId = Integer.parseInt(username);
      User user = userService.getUserById(userId);

      //入力されたユーザーIDが登録されていなかった場合。
      if (user == null) {
        throw new UsernameNotFoundException(MessageUtils.getMessage("notFoundUserIdMessage"));
      }
    return builder()
        .username(String.valueOf(user.getUserId()))
        .password(user.getPasswordHash())
        .build();
  }
  }
}
