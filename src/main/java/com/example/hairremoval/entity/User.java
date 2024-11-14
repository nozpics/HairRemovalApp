package com.example.hairremoval.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  private String user_id;  //ユーザーID
  private String user_name;  //ユーザー名
  private String password_hash; //パスワード（ハッシュ化）
}
