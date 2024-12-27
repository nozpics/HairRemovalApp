package com.example.hairremoval.service;


import com.example.hairremoval.dao.UserDao;
import com.example.hairremoval.dao.UserIdSequenceDao;
import com.example.hairremoval.entity.User;
import com.example.hairremoval.entity.UserIdSequence;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  @Autowired
  private UserDao userDao;

  @Autowired
  private UserIdSequenceDao userIdSequenceDao;

  public List<User> getAllUsers(){
    return userDao.selectAll();
  }

  public User getUserById(int userId) {
    return userDao.selectByID(userId);
  }

  //ユーザーIDを登録するために現在の最大値を取得し、その次の番号を返す。
//  public int setUserById(){
//    return userDao.selectByMaxID()+1;
//  }
  public int setUserById(){
    UserIdSequence userIdSequence = new UserIdSequence();
    userIdSequenceDao.setById(userIdSequence);
    return userIdSequenceDao.selectById();
  }

  public void accountRegister(int userId,String userName,String passwordHash){
    userDao.insertUser(userId,userName,passwordHash);
  }
}