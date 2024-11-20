package com.example.hairremoval.entity;

import org.seasar.doma.Column;
import org.seasar.doma.Entity;
import org.seasar.doma.Id;
import org.seasar.doma.Table;
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
