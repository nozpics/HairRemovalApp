package com.example.hairremoval.service;

import com.example.hairremoval.entity.User;
import static org.springframework.security.core.userdetails.User.builder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

  private final UserService userService;

  public CustomUserDetailsService(UserService userService) {
    this.userService = userService;
  }


  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    int userId = Integer.parseInt(username);
    User user = userService.getUserById(userId);

    if(user == null){
      throw new UsernameNotFoundException("User not found: " + username);
    }

    return builder()
        .username(String.valueOf(user.getUserId()))
        .password(user.getPasswordHash())
        .build();
  }
}
