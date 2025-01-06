package com.example.hairremoval.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordHashGenerator {
  public static void main(String[] args) {
    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
    String rawPassword = "test123";
    String hashedPassword = encoder.encode(rawPassword);
    System.out.println(hashedPassword);
  }
}
