package com.example.hairremoval.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "next_schedule")
@Getter
@Setter
public class NextSchedule {

  @Column(name = "user_id")
  private int user_id;  //ユーザーID　Userのuser_idと外部キーで紐づけ

  @Column(name = "body_code")
  private String body_code; //脱毛部位コード　BodyPartのbody_codeと外部キーで紐づけ済み

  @Column(name = "next_date")
  private LocalDate next_date;
}