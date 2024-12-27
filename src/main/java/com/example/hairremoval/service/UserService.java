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

  public int setUserById(){
    UserIdSequence userIdSequence = new UserIdSequence();
    userIdSequenceDao.setById(userIdSequence);
    return userIdSequenceDao.selectById();
  }

  public int accountRegister(String userName,String passwordHash){
    int userId= setUserById();
    userDao.insertUser(userId,userName,passwordHash);
    return userId;
  }

  public void saveUserUpdate(int userId,String userName,String passwordHash){
    userDao.updateUser(userId,userName,passwordHash);
  }
}