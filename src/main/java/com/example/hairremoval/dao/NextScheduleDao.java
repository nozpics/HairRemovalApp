package com.example.hairremoval.dao;

import com.example.hairremoval.config.DomaInjectConfig;
import com.example.hairremoval.entity.BodyPart;
import com.example.hairremoval.entity.NextSchedule;
import java.time.LocalDate;
import java.util.List;
import org.seasar.doma.Dao;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.Update;

@Dao
@DomaInjectConfig
public interface NextScheduleDao {

  //データベースから全ての次回予定日情報を取得する
  @Select
  List<NextSchedule> selectAll();

  //特定のユーザーIDの次回予定日を取得
  @Select
  List<NextSchedule> selectByUserId(int userId);

  //ユーザーIDと脱毛部位に基づいて次回の予定日を取得
  @Select
  NextSchedule selectByUserIdAndBodyCode(int userId, String bodyCode);

  //特定の日付の予定日を取得
  @Select
  List<NextSchedule> selectByDate(LocalDate date);

  //新しい次回予定日をデータベースに挿入
  @Insert(sqlFile = true)
  int insertSchedule(int userId, String bodyCode,LocalDate nextDate);


  //既存の次回予定日を更新
  @Update(sqlFile = true)
  int update(NextSchedule nextSchedule);

}
