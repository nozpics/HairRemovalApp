package com.example.hairremoval.service;


import com.example.hairremoval.dao.UserDao;
import com.example.hairremoval.entity.User;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  @Autowired
  private UserDao userDao;

  public List<User> getAllUsers(){
    return userDao.selectAll();
  }

  public User getUserById(int userId) {
    return userDao.selectByID(userId);
  }
}