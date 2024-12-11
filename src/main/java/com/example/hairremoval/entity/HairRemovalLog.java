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
    private int userId;

    @Column(name = "date")
    private LocalDate date;

    @Id
    @Column(name = "body_code")
    private String bodyCode;

    @Column(name = "name")
    private String name;

    @Id
    @Column(name = "session_count")
    private int sessionCount;

  }

