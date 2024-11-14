package com.example.hairremoval.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "next_schedule")
public class NextSchedule {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  private int user_id;  //ユーザーID　Userのuser_idと外部キーで紐づけ済み
  private String body_part_name; //脱毛部位　BodyPartのnameと外部キーで紐づけ済み
  private LocalDate next_date;  //次回脱毛日
}