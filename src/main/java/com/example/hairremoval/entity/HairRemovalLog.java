package com.example.hairremoval.entity;

import org.seasar.doma.Column;
import org.seasar.doma.Entity;
import org.seasar.doma.Id;
import org.seasar.doma.Table;
import java.time.LocalDate;
import lombok.Data;

@Entity
@Table(name = "hairremoval_log")
@Data
public class HairRemovalLog {

    @Id
    @Column(name = "user_id")
    private int userId;  //ユーザーID　Userのuser_idと外部キーで紐づけ

    @Column(name = "date")
    private LocalDate date;

    @Id
    @Column(name = "body_code")
    private String bodyCode;  //脱毛部位コード　BodyPartのbody_codeと外部キーで紐づけ済み

    @Id
    @Column(name = "session_count")
    private int sessionCount;

  }

