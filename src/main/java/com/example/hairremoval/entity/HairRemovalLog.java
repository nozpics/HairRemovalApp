package com.example.hairremoval.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDate;

  @Entity
  @Table(name = "log")
  public class HairRemovalLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private LocalDate date; // 脱毛日
    private String body_part; // 脱毛部位
    private int session_count; // 脱毛回数

    // Getter, Setter
  }

