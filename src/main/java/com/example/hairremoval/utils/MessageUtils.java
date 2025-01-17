package com.example.hairremoval.utils;

import java.util.Locale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

/**
 * MessageUtils
 *
 * Application起動時にmessages.propertiesを取得する
 *
 *
 */
@Component
public class MessageUtils {
  private static MessageSource messageSource;

  public MessageUtils(MessageSource messageSource){
    MessageUtils.messageSource = messageSource;
  }

  public static String getMessage(String key){
    return getMessage(key,null);
  }
  public static String getMessage(String key, Object[] args) {
    return messageSource.getMessage(key, args, Locale.JAPAN);
  }

}
