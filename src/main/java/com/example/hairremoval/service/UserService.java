package com.example.hairremoval.service;


import com.example.hairremoval.dao.UserDao;
import com.example.hairremoval.dao.UserIdSequenceDao;
import com.example.hairremoval.entity.User;
import com.example.hairremoval.entity.UserIdSequence;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

  @Autowired
  private UserDao userDao;

  @Autowired
  private UserIdSequenceDao userIdSequenceDao;

  private final PasswordEncoder passwordEncoder;

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

  public int accountRegister(String userName,String password){
    int userId= setUserById();
    String passwordHash=passwordEncoder.encode(password);
    userDao.insertUser(userId,userName,passwordHash);
    return userId;
  }

  public void saveUserUpdate(int userId,String userName,String password){
    userDao.updateUser(userId,userName,password);
  }

  public int getLoggedInUser(){

    return Integer.parseInt(SecurityContextHolder.getContext().getAuthentication().getName());
  }
}