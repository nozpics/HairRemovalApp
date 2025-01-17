package com.example.hairremoval.utils;

import java.util.Locale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

@Component
public class PropertyUtils {
  @Autowired
  private MessageSource messageSource;

  public String getMessage(String key){
    return getMessage(key,null);
  }
  public String getMessage(String key, Object[] args) {
    return messageSource.getMessage(key, args, Locale.JAPANESE);
  }

}
