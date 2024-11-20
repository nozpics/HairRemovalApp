package com.example.hairremoval.entity;

import org.seasar.doma.Column;
import org.seasar.doma.Entity;
import org.seasar.doma.Id;
import org.seasar.doma.Table;
import lombok.Data;


@Entity
@Table(name = "users")
@Data
public class User {

  @Id
  @Column(name = "user_id")
  private int user_id;

  @Column(name = "user_name")
  private String user_name;

  @Column(name = "password_hash")
  private String password_hash;
}
