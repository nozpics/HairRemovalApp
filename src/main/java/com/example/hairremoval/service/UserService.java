package com.example.hairremoval.service;


import com.example.hairremoval.dao.UserDao;
import com.example.hairremoval.dao.UserIdSequenceDao;
import com.example.hairremoval.entity.User;
import com.example.hairremoval.entity.UserIdSequence;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * ユーザーに関するサービスクラス
 */
@Service
@RequiredArgsConstructor
public class UserService {

  @Autowired
  private UserDao userDao;
  @Autowired
  private UserIdSequenceDao userIdSequenceDao;

  private final PasswordEncoder passwordEncoder;
  public User getUserById(int userId) {
    return userDao.selectByID(userId);
  }

  /**
   * アカウント登録時にユーザーIDを取得する
   * @return 取得したユーザーID
   */
  public int setUserById(){
    UserIdSequence userIdSequence = new UserIdSequence();
    userIdSequenceDao.setById(userIdSequence);
    return userIdSequenceDao.selectById();
  }

  /**
   * パスワードをハッシュ化後、アカウント情報を登録しユーザーIDを返す
   * @param userName 入力されたユーザー名
   * @param password 入力されたパスワード
   * @return ユーザーID
   */
  public int accountRegister(String userName,String password){
    int userId= setUserById();
    String passwordHash=passwordEncoder.encode(password);
    userDao.insertUser(userId,userName,passwordHash);
    return userId;
  }

  /**
   * パスワードをハッシュ化後、アカウント情報を更新する
   * @param userId 入力されたユーザーID
   * @param userName 入力されたユーザー名
   * @param password 入力されたパスワード
   */
  public void saveUserUpdate(int userId,String userName,String password){
    String passwordHash=passwordEncoder.encode(password);
    userDao.updateUser(userId,userName,passwordHash);
  }

  /**
   * 認証を受けたユーザーIDを返す
   * @return ユーザーID
   */
  public int getLoggedInUser(){
    return Integer.parseInt(SecurityContextHolder.getContext().getAuthentication().getName());
  }
}