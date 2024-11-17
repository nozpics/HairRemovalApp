package com.example.hairremoval.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;


@Entity
@Table(name = "body_part")
@Data
public class BodyPart {

  @Id
  @Column(name = "body_code")
  private String body_code;

  @Column(name = "name")
  private String name;

}
