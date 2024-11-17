package com.example.hairremoval.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "users")
@Getter
@Setter
public class User {

  @Id
  @Column(name = "user_id")
  private String user_id;

  @Column(name = "user_name")
  private String user_name;

  @Column(name = "password_hash")
  private String password_hash;
}
