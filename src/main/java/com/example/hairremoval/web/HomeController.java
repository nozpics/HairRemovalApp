package com.example.hairremoval.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Webコントローラ
 *
 */
@Controller
@Slf4j
public class HomeController {

  /**
   * 脱毛管理画面のコントローラ
   *
   */

  @GetMapping("/home")
  public String get(String userName){
    return "home";
  }
}
