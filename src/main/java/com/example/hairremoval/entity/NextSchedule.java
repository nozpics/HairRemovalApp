package com.example.hairremoval.entity;

import org.seasar.doma.Column;
import org.seasar.doma.Entity;
import org.seasar.doma.Table;
import java.time.LocalDate;
import lombok.Data;


@Entity
@Table(name = "next_schedule")
@Data
public class NextSchedule {

  @Column(name = "user_id")
  private int userId;  //ユーザーID　Userのuser_idと外部キーで紐づけ

  @Column(name = "body_code")
  private String bodyCode; //脱毛部位コード　BodyPartのbody_codeと外部キーで紐づけ済み

  @Column(name = "next_date")
  private LocalDate nextDate;
}