package com.example.hairremoval.entity;

import org.seasar.doma.Column;
import org.seasar.doma.Entity;
import org.seasar.doma.Id;
import org.seasar.doma.Table;
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

