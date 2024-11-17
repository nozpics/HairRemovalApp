package com.example.hairremoval.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDate;
import lombok.Data;

@Entity
@Table(name = "log")
@Data
public class Log {

    @Id
    @Column(name = "user_id")
    private int user_id;  //ユーザーID　Userのuser_idと外部キーで紐づけ

    @Column(name = "date")
    private LocalDate date;

    @Id
    @Column(name = "body_code")
    private String body_code;  //脱毛部位コード　BodyPartのbody_codeと外部キーで紐づけ済み

    @Id
    @Column(name = "session_count")
    private int session_count;

  }

