package com.example.hairremoval.entity;

import org.seasar.doma.Column;
import org.seasar.doma.Entity;
import org.seasar.doma.Table;
import java.time.LocalDate;
import lombok.Data;


@Entity
@Table(name = "next_schedule")
@Data
public class NextSchedule implements Comparable<NextSchedule>{

  @Column(name = "user_id")
  private int userId;

  @Column(name = "body_code")
  private String bodyCode;

  @Column(name = "nextDate")
  private LocalDate nextDate;

  @Column(name = "max_next_date")
  private LocalDate maxNextDate;

  @Column(name = "name")
  private String name;

  @Column(name = "sessionCount")
  private int sessionCount;

  @Override
  public int compareTo(NextSchedule other){
    return this.nextDate.compareTo(other.nextDate);
  }
}