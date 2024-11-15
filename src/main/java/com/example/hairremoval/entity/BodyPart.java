package com.example.hairremoval.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "body_part")
public class BodyPart {

  @Id
  @Column(name = "body_code")
  private String body_code;

  @Column(name = "name")
  private String name;

}
