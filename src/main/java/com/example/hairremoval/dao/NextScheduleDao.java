package com.example.hairremoval.dao;

import com.example.hairremoval.config.DomaInjectConfig;
import com.example.hairremoval.entity.NextSchedule;
import java.time.LocalDate;
import java.util.List;
import org.seasar.doma.Dao;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;


@Dao
@DomaInjectConfig
public interface NextScheduleDao {

  //特定のユーザーIDの次回予定日を取得
  @Select
  List<NextSchedule> selectByUserId(int userId);

  //新しい次回予定日をデータベースに挿入
  @Insert(sqlFile = true)
  int insertSchedule(int userId, String bodyCode,LocalDate nextDate);

}
